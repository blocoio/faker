package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData

class Placeholdit(data: FakerData) : FakerComponent(data) {
    fun image(
        size: String = "300x300",
        format: String = "png",
        backgroundColor: String? = null,
        textColor: String? = null,
        text: String? = null
    ): String {
        require(size.matches(SIZE_REGEX.toRegex())) { "Size should be specified in format 300x300" }
        require(SUPPORTED_FORMATS.contains(format)) { "Supported formats are ${SUPPORTED_FORMATS.joinToString(",")}" }
        backgroundColor?.let {
            require(it.matches(HEX_REGEX.toRegex())) { "backgroundColor must be a hex value without '#'" }
        }
        require(!(backgroundColor == null && textColor != null)) { "backgroundColor must be used with the textColor" }
        textColor?.let {
            require(it.matches(HEX_REGEX.toRegex())) { "textColor must be a hex value without '#'" }
        }

        var imageUrl = "$PLACEHOLDER_URL$size.$format"
        backgroundColor?.let { imageUrl += "/$it" }
        textColor?.let { imageUrl += "/$it" }
        text?.let { imageUrl += "?text=$it" }

        return imageUrl
    }

    companion object {
        val SUPPORTED_FORMATS = listOf("png", "jpg", "jpeg", "gif")
        private const val PLACEHOLDER_URL = "https://placehold.it/"
        private const val SIZE_REGEX =  "^[0-9]+x[0-9]+$";
        private const val HEX_REGEX = "((?:^[0-9a-fA-F]{3}$)|(?:^[0-9a-fA-F]{6}$)){1}(?!.*[^0-9a-fA-F])"
    }
}