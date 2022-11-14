package com.theexecutinglab.tlink.utlis;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Constants {
    public static final String LINK = "https://api.douyin.wtf/api?url=";

    public static String formatValue(double value) {
        int power;
        String suffix = " kmbt";
        String formattedNumber = "";

        NumberFormat formatter = new DecimalFormat("#,###.#");
        power = (int)StrictMath.log10(value);
        value = value/(Math.pow(10, power/3 *3));
        formattedNumber=formatter.format(value);
        formattedNumber = formattedNumber + suffix.charAt(power/3);
        return formattedNumber.length()>4 ?  formattedNumber.replaceAll("\\.[0-9]+", "") : formattedNumber;
    }
}
