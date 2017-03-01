package com.flyfanr.helloworld;

import android.app.Application;
import android.util.StringBuilderPrinter;

/**
 * Created by liuziyu on 16/7/14.
 */
public class App extends Application {

    private String textData = "Default";
    public void setTextData(String textData)
    {
        this.textData = textData;
    }
    public String getTextData() {
        return textData;
    }
}
