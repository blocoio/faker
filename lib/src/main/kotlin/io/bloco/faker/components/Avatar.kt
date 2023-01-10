package io.bloco.faker.components

import io.bloco.faker.FakerComponent
import io.bloco.faker.FakerData

class Avatar(data: FakerData) : FakerComponent(data) {
    fun image(
        slug: String? = null,
        size: String = "300x300",
        format: String = "png",
        set: String = "set1",
        bgset: String? = null
    ): String {
        var slug = slug
        if (!size.matches("^[0-9]+x[0-9]+$".toRegex())) {
            throw IllegalArgumentException("Size should be specified in format 300x300")
        }
        if (!SUPPORTED_FORMATS.contains(format)) {
            throw IllegalArgumentException(
                "Supported formats are "
                        + stringHelper.join(SUPPORTED_FORMATS, ",")
            )
        }
        if (slug == null) {
            slug = "image"
        }
        val bgset_query = (if (bgset != null) "&bgset=$bgset" else "")
        return "$AVATAR_URL$slug.$format?size=$size&set=$set$bgset_query"
    }

    companion object {
        val SUPPORTED_FORMATS: List<String> = mutableListOf("png", "jpg", "bmp")
        private const val AVATAR_URL = "https://robohash.org/"
    }
}