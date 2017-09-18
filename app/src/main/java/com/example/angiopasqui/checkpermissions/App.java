package com.example.angiopasqui.checkpermissions;

import android.graphics.drawable.Drawable;

/**
 * Created by Angiopasqui on 18/09/2017.
 */

public class App {
    private String name;
    private Drawable icon;

    public App(){

    }

    public App(String name, Drawable icon){
        this.name = name;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }
}
