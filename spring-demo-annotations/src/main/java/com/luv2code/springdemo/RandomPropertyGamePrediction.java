package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomPropertyGamePrediction implements GamePredictionService {

    @Value("${PREDICTIONS}")
    private String predictions;

    private Random random = new Random();

    @Override
    public String getGamePrediction() {
        String[] predictionsArray = predictions.split(",");
        Integer randomNum = random.nextInt(predictionsArray.length);
        return predictionsArray[randomNum];
    }
}
