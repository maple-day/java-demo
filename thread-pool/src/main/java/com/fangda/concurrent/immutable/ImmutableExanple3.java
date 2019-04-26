package com.fangda.concurrent.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import lombok.extern.java.Log;

import java.util.logging.Level;

@Log
public class ImmutableExanple3 {

    private final static ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder()
            .put(1, 2).put(3, 4).put(5, 6).build();

    public static void main(String[] args) {
        ImmutableList.Builder<String> builder = ImmutableList.builder();
        builder.add("785");
        ImmutableList<String> build = builder.build();
        log.log(Level.INFO, build.get(0));

        ImmutableList<String> immutableList = ImmutableList.of("788", "4sss");
        log.log(Level.INFO, immutableList.get(1));

        log.log(Level.INFO, map2.toString());

    }
}
