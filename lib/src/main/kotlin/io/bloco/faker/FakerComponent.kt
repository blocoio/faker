package io.bloco.faker

import io.bloco.faker.helpers.RandomHelper
import io.bloco.faker.helpers.StringHelper
import java.lang.reflect.InvocationTargetException

abstract class FakerComponent(private val data: FakerData) {
    protected val randomHelper: RandomHelper = RandomHelper()
    protected val stringHelper: StringHelper = StringHelper()

    val key: String
        get() = stringHelper.camelToSnake(this.javaClass.simpleName)

    fun fetch(key: String): String {
        val keys = key.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val list = if (keys.size == 2) {
            getList(keys[0], keys[1])
        } else {
            getMap(keys[0], keys[1])[keys[2]] as List<*>
        }
        return sampleFromList(list)
    }

    fun numerify(input: String): String {
        return stringHelper.replaceMethod(input, DIGIT_SYMBOL
        ) { randomHelper.digit() }
    }

    fun parse(input: String): String {
        return stringHelper.replaceMethod(input, PARSE_REGEXP
        ) { matcher ->
            val key = matcher.group(1)
            call(key)
        }
    }

    fun call(key: String): String {
        return if (key.contains(".")) {
            val keys = key.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            data.getComponentByKey(keys[0]).callMethod(keys[1])
        } else {
            callMethod(key)
        }
    }

    protected val separator: String
        get() = data["separator"] as String

    protected fun sampleFromList(options: List<*>): String {
        return when (val option = randomHelper.sample(options)) {
            is String -> {
                option
            }
            is List<*> -> { // List of lists
                randomHelper.sample(option) as String
            }
            else -> {
                throw UnsupportedOperationException("Unsupported data type")
            }
        }
    }

    protected fun getList(componentKey: String, listKey: String): List<*> {
        return getComponentData(componentKey)[listKey] as List<*>?
            ?: throw UnsupportedOperationException("Unsupported method '$listKey'")
    }

    protected fun <K : FakerComponent?> getComponent(klass: Class<K>): K {
        try {
            return klass.getConstructor(FakerData::class.java).newInstance(data)
        } catch (e: InstantiationException) {
            throw IllegalArgumentException("Unsupported component '$klass'", e)
        } catch (e: NoSuchMethodException) {
            throw IllegalArgumentException("Unsupported component '$klass'", e)
        } catch (e: IllegalAccessException) {
            throw IllegalArgumentException("Unsupported component '$klass'", e)
        } catch (e: InvocationTargetException) {
            throw IllegalArgumentException("Unsupported component '$klass'", e)
        }
    }

    private fun callMethod(methodKey: String): String {
        val methodKeyCamel: String = stringHelper.snakeToCamel(methodKey)
        val value: String
        try {
            value = javaClass.getDeclaredMethod(methodKeyCamel).invoke(this) as String
        } catch (e: NoSuchMethodException) {
            throw IllegalArgumentException(
                "Unsupported method '" + methodKey + "' " +
                        "for component '" + key + "'", e
            )
        } catch (e: IllegalAccessException) {
            throw IllegalArgumentException(
                ("Unsupported method '" + methodKey + "' " +
                        "for component '" + key + "'"), e
            )
        } catch (e: InvocationTargetException) {
            throw IllegalArgumentException(
                ("Unsupported method '" + methodKey + "' " +
                        "for component '" + key + "'"), e
            )
        }
        return value
    }

    protected fun getMap(componentKey: String, listKey: String): Map<String, Any> {
        return getComponentData(componentKey)[listKey] as Map<String, Any>?
            ?: throw UnsupportedOperationException("Unsupported method '$listKey'")
    }

    private fun getComponentData(componentKey: String): Map<String, Any> {
        return data.getComponentData(componentKey)
    }

    companion object {
        private const val DIGIT_SYMBOL = "#"
        private const val PARSE_REGEXP = "\\#\\{(.+?)\\}"
    }
}