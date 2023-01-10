package io.bloco.faker.helpers

enum class Period(val values: IntArray) {
    all(
        intArrayOf(
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23
        )
    ),
    day(intArrayOf(9, 10, 11, 12, 13, 14, 15, 16, 17)), night(intArrayOf(18, 19, 20, 21, 22, 23)), morning(
        intArrayOf(
            6,
            7,
            8,
            9,
            10,
            11
        )
    ),
    afternoon(
        intArrayOf(12, 13, 14, 15, 16, 17)
    ),
    evening(intArrayOf(17, 18, 19, 20, 21)), midnight(intArrayOf(0, 1, 2, 3, 4))

}