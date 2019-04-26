package com.fangda.concurrent.immutable;

import com.google.common.collect.Maps;
import lombok.extern.java.Log;

import java.util.Collections;
import java.util.Map;
import java.util.logging.Level;

@Log
public class ImmutableExanple2 {

    private static Map<Integer, Integer> map = Maps.newHashMap();


    static {

        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
        //返回指定有序映射的不可修改视图
        map = Collections.unmodifiableMap(map);

    }

    public static void main(String[] args) {


        //map.put(1, 3);

        log.log(Level.INFO, map.get(1).toString());
    }
}
