package com.ycxy.wdgj.common.utils;

import java.util.Random;

import com.ycxy.wdgj.common.exception.OmsException;

public class MathUtils {
    private static Random random = new Random();

    public static int getRandomNum4B() {
        int num = random.nextInt(8999) + 1000;
        return num;
    }

    public static int getRandomNum6B() {
        int num = random.nextInt(899999) + 100000;
        return num;
    }

    public static Integer getAdd(Integer a, Integer b) {
        if (!ObjectUtils.isEmpty(a, b)) {
            if (a == null && b != null) {
                return b;
            } else if (a != null && b == null) {
                return a;
            } else {
                return a + b;
            }
        }
        return null;
    }

    public static Double getSub(Double a, Double b) {
        if (!ObjectUtils.isEmpty(a, b)) {
            if (a == null && b != null) {
                return b;
            } else if (a != null && b == null) {
                return a;
            } else {
                return a - b;
            }
        }
        return null;
    }

    public static Double getAdd(Double a, Double b) {
        if (!ObjectUtils.isEmpty(a, b)) {
            if (a == null && b != null) {
                return b;
            } else if (a != null && b == null) {
                return a;
            } else {
                return a + b;
            }
        }
        return null;
    }

    public static Double divid(Double a, Double b) throws OmsException {
        if (!ObjectUtils.isEmpty(a, b)) {
            if (a == null && b != null) {
                return null;
            } else if (a != null && b == null) {
                throw new OmsException("分母不为0");
            } else {
                return a / b;
            }
        }
        return null;
    }
}
