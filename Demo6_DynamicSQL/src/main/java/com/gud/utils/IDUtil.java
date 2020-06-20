package com.gud.utils;

import org.junit.jupiter.api.Test;

import java.util.UUID;

/**
 * Created by david.w on 2020/6/20.
 */

public class IDUtil {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    @Test
    public void test(){
        System.out.println(getId());
    }

}
