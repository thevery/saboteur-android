package com.thevery.saboteur.android.model.util;

import java.util.HashMap;
import java.util.Map;

public class Array2D<T> {
    private Map<Integer, Map<Integer, T>> array = new HashMap<Integer, Map<Integer, T>>();

    public void put(int x, int y, T value) {
        Map<Integer, T> line = array.get(x);
        if (line == null) {
            line = new HashMap<Integer, T>();
            array.put(x, line);
        }
        line.put(y, value);
    }

    public T get(int x, int y) {
        Map<Integer, T> line = array.get(x);
        if (line != null) {
            return line.get(y);
        } else {
            return null;
        }
    }

    public T get(int x, int y, T defaultValue) {
        T value = get(x, y);
        return value != null ? value : defaultValue;
    }

}
