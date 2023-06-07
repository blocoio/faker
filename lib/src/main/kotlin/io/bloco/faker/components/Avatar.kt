package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData

class Avatar(data: FakerData) : FakerComponent(data) {
    fun image(
        slug: String? = "image",
        size: String = "300x300",
        format: String = "png",
        set: String = "set1",
        bgset: String? = null
    ): String {
        require(size.matches("^\\d+x\\d+$".toRegex())) {
            "Size should be specified in format 300x300"
        }
        require(SUPPORTED_FORMATS.contains(format)) {
            "Supported formats are ${SUPPORTED_FORMATS.joinToString(",")}"
        }

        val bgsetQuery = bgset?.let { "&bgset=$it" }.orEmpty()
        return "$AVATAR_URL${slug}.$format?size=$size&set=$set$bgsetQuery"
    }


    companion object {
        val SUPPORTED_FORMATS: List<String> = listOf("png", "jpg", "bmp")
        private const val AVATAR_URL = "https://robohash.org/"
    }
}