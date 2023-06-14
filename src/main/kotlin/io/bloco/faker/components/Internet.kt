package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData
import io.bloco.faker.helpers.RandomHelper
import io.bloco.faker.helpers.normalize

class Internet(data: FakerData) : FakerComponent(data) {

    @JvmOverloads
    fun email(name: String? = null): String {
        return userName(name) + "@" + domainName()
    }

    @JvmOverloads
    fun freeEmail(name: String? = null): String {
        return userName(name) + "@" + fetch("internet.free_email")
    }

    @JvmOverloads
    fun safeEmail(name: String? = null): String {
        return userName(name) + "@" + SAFE_EMAIL_HOST + RandomHelper.sample(SAFE_EMAIL_TLDS)
    }

    @JvmOverloads
    fun userName(specifier: String? = null, separators: List<String> = DEFAULT_SEPARATORS): String {
        val separator = RandomHelper.sample(separators)
        return when {
            specifier != null -> {
                specifier.split("\\s+".toRegex())
                    .joinToString(separator) { it.normalize() }
            }
            RandomHelper.randBoolean() -> {
                call("Name.first_name").normalize() + separator +
                    call("Name.last_name").normalize()
            }
            else -> {
                call("Name.first_name").normalize()
            }
        }
    }

    @JvmOverloads
    fun password(
        minLength: Int = PASSWORD_MIN_LENGTH,
        maxLength: Int = PASSWORD_MAX_LENGTH,
        mixCase: Boolean = PASSWORD_MIX_CASE,
        specialChars: Boolean = PASSWORD_SPECIAL_CHARS
    ): String {
        val characterCount = RandomHelper.range(minLength, maxLength)
        var password: String = getComponent(Lorem::class).characters(characterCount)
        if (mixCase && password.length >= 2) {
            val middlePoint = RandomHelper.number(password.length - 1) + 1
            password =
                password.substring(0, middlePoint).lowercase() + password.substring(middlePoint)
                .uppercase()
        }

        if (specialChars && password.length >= 2) {
            val numSpecialChars = RandomHelper.number(password.length - 1) + 1
            repeat(numSpecialChars) {
                val specialChar = RandomHelper.sample(PASSWORD_SPECIAL_CHARS_LIST)
                val index = RandomHelper.number(password.length)
                password =
                    password.substring(0, index).lowercase() + specialChar + password.substring(
                    index + 1
                ).uppercase()
            }
        }
        return password
    }

    fun domainName(): String {
        return domainWord() + '.' + domainSuffix()
    }

    fun domainWord(): String {
        val companyName = call("Company.name")
        return companyName.normalize()
    }

    fun domainSuffix(): String {
        return fetch("internet.domain_suffix")
    }

    @JvmOverloads
    fun macAddress(prefix: String = ""): String {
        val prefixDigits = prefix.split(":").filterNot { it.isEmpty() }
        val addressDigits =
            (0 until (6 - prefixDigits.size)).map { "%02x".format(RandomHelper.number(256)) }
        return (prefixDigits + addressDigits).joinToString(":")
    }

    fun ipV4Address(): String {
        val parts = List(4) { RandomHelper.number(256) }
        return parts.joinToString(".")
    }

    fun ipV4Cidr(): String {
        return ipV4Address() + "/" + RandomHelper.range(1, 32)
    }

    fun ipV6Address(): String {
        val parts = List(8) { "%x".format(RandomHelper.number(65536)) }
        return parts.joinToString(":")
    }

    fun ipV6Cidr(): String {
        return ipV6Address() + "/" + RandomHelper.range(1, 128)
    }

    @JvmOverloads
    fun url(host: String = domainName(), path: String = "/" + userName()): String {
        return "http://$host$path"
    }

    @JvmOverloads
    fun slug(
        words: List<String> = listOf(fetch("lorem.words"), fetch("lorem.words")),
        glue: String = RandomHelper.sample(DEFAULT_SLUG_GLUE)
    ): String {
        return words.joinToString(glue)
    }

    fun deviceToken(): String {
        return (1..DEVICE_TOKEN_LENGTH).joinToString("") {
            RandomHelper.number(16).toString(16)
        }
    }

    companion object {
        private const val SAFE_EMAIL_HOST = "example."
        private val SAFE_EMAIL_TLDS = listOf("org", "com", "net")
        private val DEFAULT_SEPARATORS = listOf(".", "_")
        private val DEFAULT_SLUG_GLUE = listOf(".", "_", "-")
        private const val PASSWORD_MIN_LENGTH = 8
        private const val PASSWORD_MAX_LENGTH = 16
        private const val PASSWORD_MIX_CASE = true
        private const val PASSWORD_SPECIAL_CHARS = false
        private val PASSWORD_SPECIAL_CHARS_LIST = listOf("!", "@", "#", "$", "%", "^", "&", "*")
        private const val DEVICE_TOKEN_LENGTH = 64
    }
}
