package io.bloco.faker.helpers

import java.text.Normalizer
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

class StringHelper {
    interface StringReplacer {
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
        return replaceMethod(input, "_(\\p{Lower})", object : StringReplacer {
            override fun replaceWith(matcher: Matcher): String {
                val letter = matcher.group(1)
                return letter.uppercase(Locale.getDefault())
            }
        })
    }

    fun camelToSnake(input: String): String {
        return replaceMethod(input, "(?<=\\w)(\\p{Upper})", object : StringReplacer {
            override fun replaceWith(matcher: Matcher): String {
                return "_" + matcher.group(1)
            }
        }).lowercase(Locale.getDefault())
    }

    fun join(list: List<String>, separator: String): String {
        val sb = StringBuilder()
        var first = true
        for (item in list) {
            if (first) first = false else sb.append(separator)
            sb.append(item)
        }
        return sb.toString()
    }

    fun normalize(input: String): String {
        var normalized = Normalizer.normalize(input, Normalizer.Form.NFD) // Separate glyphs
        normalized = normalized.replace("[^\\p{ASCII}]".toRegex(), "") // Remove glyphs
        normalized = normalized.replace("\\W".toRegex(), "") // Remove anything but letters and numbers
        return normalized.lowercase(Locale.getDefault())
    }
}