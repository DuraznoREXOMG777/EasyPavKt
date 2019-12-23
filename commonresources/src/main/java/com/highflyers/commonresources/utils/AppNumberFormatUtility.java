package com.highflyers.commonresources.utils;

import android.content.Context;

import com.highflyers.commonresources.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class AppNumberFormatUtility {

    public static Locale getLocaleMX() {
        return new Locale("es", "MX");
    }

    public static String getCurrencySymbolMX() {
        return Currency.getInstance(getLocaleMX()).getSymbol(getLocaleMX());
    }

    public static String formatPrice(Context context, Double value) {
        DecimalFormat format = new DecimalFormat("#,###.##");
        format.setDecimalSeparatorAlwaysShown(true);
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);
        String priceFormatted = "";
        try {
            priceFormatted = format.format(value);
        }catch(IllegalArgumentException ex){
            System.out.println(value);
        }
        String currencySymbol = getCurrencySymbolMX();
        return String.format(context.getResources().getString(R.string.item_credit_amount_format), currencySymbol, priceFormatted);
    }

    public static String formatPercentage(Double value){
        NumberFormat format = NumberFormat.getPercentInstance();
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(2);
        return format.format(value/100);
    }
    
}
