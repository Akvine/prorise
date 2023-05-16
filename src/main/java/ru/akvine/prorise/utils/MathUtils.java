package ru.akvine.prorise.utils;

import org.springframework.stereotype.Component;

@Component
public class MathUtils {
    public double round(double value, int accuracy) {
        if (accuracy < 0) {
            throw new IllegalArgumentException("Accuracy can't be less than 0!");
        }

        double scale = Math.pow(10, accuracy);
        return Math.round(value * scale) / scale;
    }
}
