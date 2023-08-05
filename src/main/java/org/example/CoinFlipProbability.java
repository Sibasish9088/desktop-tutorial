package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CoinFlipProbability {

    public static Map<HashMap<String, Integer>, Double> calculateProbabilityOf(int flips) {

        int headCount = 0;
        int tailCount = 0;
        int coin;
        Random randomNumber = new Random();
        Map<String, Integer> countMapper = new HashMap<>();
        Map<HashMap<String, Integer>, Double> probabilityMapper = new HashMap<>();
        for (int i = 0; i < flips; i++) {

            coin = randomNumber.nextInt(2);
            if (coin == 0) {
                System.out.println("Heads");
                headCount++;

            } else {
                System.out.println("Tails");
                tailCount++;
            }
        }

        countMapper.put("Heads", headCount);
        countMapper.put("Tails", tailCount);

        System.out.println("These are the counts for the count flip for " + flips + " flips:");
        for (Map.Entry<String, Integer> count : countMapper.entrySet()) {
            System.out.println(count.getKey() + " = " + count.getValue());
            probabilityMapper.put(new HashMap<>() {
                {
                    put(count.getKey(), count.getValue());
                }
            }, count.getValue() * 1.0 / flips);
        }

        return probabilityMapper;
    }
}
