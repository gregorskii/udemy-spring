package com.example.luv2code.springdemo.PredictionService;

public class HappyGamePredictionService implements GamePredictionService {

    @Override
    public String getGamePrediction() {
        return "You will win!";
    }
}
