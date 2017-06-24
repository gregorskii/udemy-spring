package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class SadGamePrediction implements GamePredictionService {

    @Override
    public String getGamePrediction() {
        return "You will lose!";
    }
}
