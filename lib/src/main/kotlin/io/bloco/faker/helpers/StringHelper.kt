package io.bloco.faker.helpers

import java.text.Normalizer
import java.util.*
import java.util.regex.Pattern

class StringHelper {
    fun snakeToCamel(input: String): String {
        return input.replace("_(\\p{Lower})".toRegex()) { matcher ->
            matcher.groupValues[1].uppercase(Locale.getDefault())
        }
    }

    fun camelToSnake(input: String): String {
        return input.replace("(?<=\\w)(\\p{Upper})".toRegex()) { matcher ->
            "_" + matcher.groupValues[1].lowercase(Locale.getDefault())
        }.lowercase(Locale.getDefault())
    }

    fun normalize(input: String): String {
        val asciiPattern = Pattern.compile("[^\\p{ASCII}]")
        val nonWordPattern = Pattern.compile("\\W")

        var normalized = Normalizer.normalize(input, Normalizer.Form.NFD) // Separate glyphs
        normalized = asciiPattern.matcher(normalized).replaceAll("") // Remove glyphs
        normalized = nonWordPattern.matcher(normalized)
            .replaceAll("") // Remove anything but letters and numbers
        return normalized.lowercase(Locale.getDefault())
    }
}
