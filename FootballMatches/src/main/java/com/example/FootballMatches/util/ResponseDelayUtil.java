package com.example.FootballMatches.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ResponseDelayUtil {

    private static final int MIN_DELAY = 3000; // 3 seconds
    private static final int MAX_DELAY = 6000; // 6 seconds

    public void delayResponse() {
        Random random = new Random();
        int delay = random.nextInt(MAX_DELAY - MIN_DELAY) + MIN_DELAY;
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
