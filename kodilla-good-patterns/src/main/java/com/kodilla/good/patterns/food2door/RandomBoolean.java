package com.kodilla.good.patterns.food2door;

import java.util.Random;

public class RandomBoolean {
    public static boolean randomBoolean() {
        switch (new Random().nextInt(2)) {
            case 0: return false;
            case 1: return true;
            default: return false;
        }
    }
}
