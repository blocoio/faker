package io.bloco.faker.helpers

import java.text.Normalizer
import java.util.*
import java.util.regex.Pattern

fun String.snakeToCamel(): String {
    return this.replace("_(\\p{Lower})".toRegex()) { matcher ->
        matcher.groupValues[1].uppercase(Locale.getDefault())
    }
}

fun String.camelToSnake(): String {
    return this.replace("(?<=\\w)(\\p{Upper})".toRegex()) { matcher ->
        "_" + matcher.groupValues[1].lowercase(Locale.getDefault())
    }.lowercase(Locale.getDefault())
}

fun String.normalize(): String {
    val asciiPattern = Pattern.compile("[^\\p{ASCII}]")
    val nonWordPattern = Pattern.compile("\\W")

    var normalized = Normalizer.normalize(this, Normalizer.Form.NFD) // Separate glyphs
    normalized = asciiPattern.matcher(normalized).replaceAll("") // Remove glyphs
    normalized = nonWordPattern.matcher(normalized)
        .replaceAll("") // Remove anything but letters and numbers
    return normalized.lowercase(Locale.getDefault())
}
