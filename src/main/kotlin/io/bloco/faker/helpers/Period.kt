package io.bloco.faker.helpers

enum class Period(val values: IntArray) {
    All((0..23).toList().toIntArray()),
    Day((9..17).toList().toIntArray()),
    Night((18..23).toList().toIntArray()),
    Morning((6..11).toList().toIntArray()),
    Afternoon((12..17).toList().toIntArray()),
    Evening((17..21).toList().toIntArray()),
    Midnight((0..4).toList().toIntArray())
}
