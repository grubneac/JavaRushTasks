package com.javarush.task.task15.task1522;

public final class Moon implements Planet{
    private static Moon instance = null;

    public static Moon getInstance() {
        if(instance==null)instance=new Moon();
        return instance;
    }

    private Moon() {
    }
}
