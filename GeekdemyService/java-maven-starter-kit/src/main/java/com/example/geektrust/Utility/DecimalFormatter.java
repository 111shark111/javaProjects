package com.example.geektrust.Utility;

import java.text.DecimalFormat;

public class DecimalFormatter {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static String format(double value) {
        return df.format(value);
    }

    public static double formatToDouble(double value) {
        return Double.parseDouble(df.format(value));
    }
}
