package io.bloco.faker.helpers

import java.text.Normalizer
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class StringHelper {
    fun interface StringReplacer {
        fun replaceWith(matcher: Matcher): String
    }

    fun replaceMethod(input: String, regex: String, replacer: StringReplacer): String {
        val pattern = Pattern.compile(regex)
        val matcher = pattern.matcher(input)
        val stringBuffer = StringBuffer()
        while (matcher.find()) {
            val replacement = replacer.replaceWith(matcher)
            matcher.appendReplacement(stringBuffer, replacement)
        }
        matcher.appendTail(stringBuffer)
        return stringBuffer.toString()
    }

    fun snakeToCamel(input: String): String {
        return replaceMethod(input, "_(\\p{Lower})") { matcher ->
            matcher.group(1).uppercase(Locale.getDefault())
        }
    }

    fun camelToSnake(input: String): String {
        return replaceMethod(input, "(?<=[a-zA-Z0-9])(\\p{Upper})") { matcher ->
            "_" + matcher.group(1).lowercase(Locale.getDefault())
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