package io.bloco.faker.helpers;

public enum Period {

    all(new int[]{
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23
    }),
    day(new int[]{9, 10, 11, 12, 13, 14, 15, 16, 17}),
    night(new int[]{18, 19, 20, 21, 22, 23}),
    morning(new int[]{6, 7, 8, 9, 10, 11}),
    afternoon(new int[]{12, 13, 14, 15, 16, 17}),
    evening(new int[]{17, 18, 19, 20, 21}),
    midnight(new int[]{0, 1, 2, 3, 4});

    private final int[] values;

    Period(int[] values) {
        this.values = values;
    }

    public int[] getValues() {
        return values;
    }
}
