package com.fangda.concurrent.immutable;

import com.google.common.collect.Maps;
import lombok.extern.java.Log;

import java.util.HashMap;
import java.util.logging.Level;

@Log
public class ImmutableExanple1 {

    private final static HashMap<Integer, Integer> map = Maps.newHashMap();
    private final static String b = "b";
    private final static Integer a = 1;

    static {

        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
//        b = "a";
//        a = 5;
        map.put(1, 3);
        log.log(Level.INFO, map.get(1).toString());

    }
}
