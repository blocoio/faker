package io.bloco.faker.components;

import io.bloco.faker.FakerComponent;
import io.bloco.faker.FakerData;
import io.bloco.faker.helpers.MathHelper;

public class Color extends FakerComponent {

    public static final int MAX_RGB = 256;
    public static final double MAX_HSL = 360d;

    private MathHelper mathHelper;

    public Color(FakerData data) {
        super(data);
        mathHelper = new MathHelper();
    }

    public String hexColor() {
        return String.format("#%06x", randomHelper.number((int) Math.pow(MAX_RGB, 3)));
    }

    public String colorName() {
        return fetch("color.name");
    }

    public int singleRgbColor() {
        return randomHelper.number(MAX_RGB);
    }

    public int[] rgbColor() {
        return new int[]{singleRgbColor(), singleRgbColor(), singleRgbColor()};
    }

    public double singleHslColor() {
        return mathHelper.round(randomHelper.range(0, MAX_HSL), 2);
    }

    public double alphaChannel() {
        return randomHelper.randDouble();
    }

    public double[] hslColor() {
        return new double[]{singleHslColor(), singleHslColor(), singleHslColor()};
    }

    public double[] hslaColor() {
        return new double[]{singleHslColor(), singleHslColor(), singleHslColor(), alphaChannel()};
    }
}
