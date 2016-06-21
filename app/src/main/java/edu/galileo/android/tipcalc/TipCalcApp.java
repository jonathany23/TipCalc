package edu.galileo.android.tipcalc;

import android.app.Application;

/**
 * Created by jonathan on 6/20/2016.
 */
public class TipCalcApp extends Application {
    private final static String ABOUT_URL = "https://about.me/jonathany23";

    public String getAboutUrl() {
        return ABOUT_URL;
    }
}
