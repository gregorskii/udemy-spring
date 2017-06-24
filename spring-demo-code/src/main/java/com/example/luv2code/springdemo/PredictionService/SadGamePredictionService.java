package com.example.luv2code.springdemo.PredictionService;

public class SadGamePredictionService implements GamePredictionService {
    @Override
    public String getGamePrediction() {
        return "You are going to lose!";
    }
}
