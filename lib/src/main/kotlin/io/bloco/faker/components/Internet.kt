package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData
import java.util.*

class Internet(data: FakerData) : FakerComponent(data) {
    fun email(name: String? = null): String {
        return userName(name) + "@" + domainName()
    }

    fun freeEmail(name: String? = null): String {
        return userName(name) + "@" + fetch("internet.free_email")
    }

    fun safeEmail(name: String? = null): String {
        return userName(name) + "@" + SAFE_EMAIL_HOST + randomHelper.sample(SAFE_EMAIL_TLDS)
    }

    fun userName(specifier: String? = null, separators: List<String> = DEFAULT_SEPARATORS): String {
        val separator = randomHelper.sample(separators)
        return if (specifier != null) {
            val words = listOf(*specifier.split("\\s".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray())
            val normalizedWords: MutableList<String> = ArrayList(words.size)
            for (word in words) {
                normalizedWords.add(stringHelper.normalize(word))
            }
            stringHelper.join(normalizedWords, separator)
        } else if (randomHelper.randBoolean()) {
            (stringHelper.normalize(call("Name.first_name"))
                    + separator
                    + stringHelper.normalize(call("Name.last_name")))
        } else {
            stringHelper.normalize(call("Name.first_name"))
        }
    }

    fun password(
        minLength: Int = PASSWORD_MIN_LENGTH,
        maxLength: Int = PASSWORD_MAX_LENGTH,
        mixCase: Boolean = PASSWORD_MIX_CASE,
        specialChars: Boolean = PASSWORD_SPECIAL_CHARS
    ): String {
        val characterCount = randomHelper.range(minLength, maxLength)
        var password: String = getComponent(Lorem::class.java).characters(characterCount)
        if (mixCase && password.length >= 2) {
            val middlePoint = randomHelper.number(password.length - 1) + 1
            password = password.substring(0, middlePoint).lowercase(Locale.getDefault()) +
                    password.substring(middlePoint).uppercase(Locale.getDefault())
        }
        if (specialChars && password.length >= 2) {
            val numSpecialChars = randomHelper.number(password.length - 1) + 1
            for (i in 0 until numSpecialChars) {
                val specialChar = randomHelper.sample(PASSWORD_SPECIAL_CHARS_LIST)
                val index = randomHelper.number(password.length)
                password = password.substring(0, index)
                    .lowercase(Locale.getDefault()) + specialChar + password.substring(index + 1)
                    .uppercase(Locale.getDefault())
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
        val prefixDigits: List<String> = if (prefix.isNotEmpty()) {
            listOf(*prefix.split(":".toRegex()).dropLastWhile { it.isEmpty() }
                .toTypedArray())
        } else {
            ArrayList()
        }
        val addressDigitsCount = 6 - prefixDigits.size
        val addressDigits: MutableList<String> = ArrayList(addressDigitsCount)
        for (i in 0 until addressDigitsCount) {
            addressDigits.add(String.format("%02x", randomHelper.number(256)))
        }
        addressDigits.addAll(0, prefixDigits)
        return stringHelper.join(addressDigits, ":")
    }

    fun ipV4Address(): String {
        val parts: MutableList<String> = ArrayList(4)
        for (i in 0..3) {
            parts.add(randomHelper.number(255).toString())
        }
        return stringHelper.join(parts, ".")
    }

    fun ipV4Cidr(): String {
        return ipV4Address() + "/" + randomHelper.range(1, 32)
    }

    fun ipV6Address(): String {
        val parts: MutableList<String> = ArrayList(8)
        for (i in 0..7) {
            parts.add(String.format("%x", randomHelper.number(65536)))
        }
        return stringHelper.join(parts, ":")
    }

    fun ipV6Cidr(): String {
        return ipV6Address() + "/" + randomHelper.range(1, 128)
    }

    @JvmOverloads
    fun url(host: String = domainName(), path: String = "/" + userName()): String {
        return "http://$host$path"
    }

    fun slug(words: List<String>? = null, glue: String? = null): String {
        var words = words
        var glue = glue
        if (glue == null) {
            glue = randomHelper.sample(DEFAULT_SLUG_GLUE)
        }
        if (words.isNullOrEmpty()) {
            words = listOf(fetch("lorem.words"), fetch("lorem.words"))
        }
        return stringHelper.join(words, glue)
    }

    fun deviceToken(): String {
        val deviceToken = StringBuilder()
        for (i in 0 until DEVICE_TOKEN_LENGTH) {
            deviceToken.append(String.format("%x", randomHelper.number(16)))
        }
        return deviceToken.toString()
    }

    companion object {
        private const val SAFE_EMAIL_HOST = "example."
        private val SAFE_EMAIL_TLDS: List<String> = mutableListOf("org", "com", "net")
        private val DEFAULT_SEPARATORS: List<String> = mutableListOf(".", "_")
        private val DEFAULT_SLUG_GLUE: List<String> = mutableListOf(".", "_", "-")
        private const val PASSWORD_MIN_LENGTH = 8
        private const val PASSWORD_MAX_LENGTH = 16
        private const val PASSWORD_MIX_CASE = true
        private const val PASSWORD_SPECIAL_CHARS = false
        private val PASSWORD_SPECIAL_CHARS_LIST: List<String> = mutableListOf("!", "@", "#", "$", "%", "^", "&", "*")
        private const val DEVICE_TOKEN_LENGTH = 64
    }
}