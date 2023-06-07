package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData

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
        return userName(name) + "@" + SAFE_EMAIL_HOST + randomHelper.sample(SAFE_EMAIL_TLDS)
    }

    @JvmOverloads
    fun userName(specifier: String? = null, separators: List<String> = DEFAULT_SEPARATORS): String {
        val separator = randomHelper.sample(separators)
        return when {
            specifier != null -> {
                specifier.split("\\s+".toRegex())
                    .joinToString(separator) { stringHelper.normalize(it) }
            }
            randomHelper.randBoolean() -> {
                stringHelper.normalize(call("Name.first_name")) + separator + stringHelper.normalize(
                    call("Name.last_name")
                )
            }
            else -> {
                stringHelper.normalize(call("Name.first_name"))
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
        val characterCount = randomHelper.range(minLength, maxLength)
        var password: String = getComponent(Lorem::class).characters(characterCount)
        if (mixCase && password.length >= 2) {
            val middlePoint = randomHelper.number(password.length - 1) + 1
            password = password.substring(0, middlePoint).lowercase() +
                    password.substring(middlePoint).uppercase()
        }

        if (specialChars && password.length >= 2) {
            val numSpecialChars = randomHelper.number(password.length - 1) + 1
            repeat(numSpecialChars) {
                val specialChar = randomHelper.sample(PASSWORD_SPECIAL_CHARS_LIST)
                val index = randomHelper.number(password.length)
                password = password.substring(0, index).lowercase() +
                        specialChar +
                        password.substring(index + 1).uppercase()
            }
        }
        return password
    }

    fun domainName(): String {
        return domainWord() + '.' + domainSuffix()
    }

    fun domainWord(): String {
        val companyName = call("Company.name")
        return stringHelper.normalize(companyName)
    }

    fun domainSuffix(): String {
        return fetch("internet.domain_suffix")
    }

    @JvmOverloads
    fun macAddress(prefix: String = ""): String {
        val prefixDigits = prefix.split(":").filterNot { it.isEmpty() }
        val addressDigits = (0 until (6 - prefixDigits.size))
            .map { "%02x".format(randomHelper.number(256)) }
        return (prefixDigits + addressDigits).joinToString(":")
    }

    fun ipV4Address(): String {
        val parts = List(4) { randomHelper.number(256) }
        return parts.joinToString(".")
    }

    fun ipV4Cidr(): String {
        return ipV4Address() + "/" + randomHelper.range(1, 32)
    }

    fun ipV6Address(): String {
        val parts = List(8) { "%x".format(randomHelper.number(65536)) }
        return parts.joinToString(":")
    }

    fun ipV6Cidr(): String {
        return ipV6Address() + "/" + randomHelper.range(1, 128)
    }

    @JvmOverloads
    fun url(host: String = domainName(), path: String = "/" + userName()): String {
        return "http://$host$path"
    }

    @JvmOverloads
    fun slug(
        words: List<String> = listOf(fetch("lorem.words"), fetch("lorem.words")),
        glue: String = randomHelper.sample(DEFAULT_SLUG_GLUE)
    ): String {
        return words.joinToString(glue)
    }

    fun deviceToken(): String {
        return (1..DEVICE_TOKEN_LENGTH).joinToString("") {
            randomHelper.number(16).toString(16)
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