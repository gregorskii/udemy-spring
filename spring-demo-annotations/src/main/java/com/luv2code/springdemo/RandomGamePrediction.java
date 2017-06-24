package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomGamePrediction implements GamePredictionService {

    private String[] predictions = {
        "You will win!",
        "You will lose!",
        "You may win.",
        "You may lose."
    };

    private Random random = new Random();

    @Override
    public String getGamePrediction() {
        Integer randomNum = random.nextInt(predictions.length);
        return predictions[randomNum];
    }
}
