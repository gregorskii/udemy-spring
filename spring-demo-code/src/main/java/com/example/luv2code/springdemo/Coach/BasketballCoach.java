package com.example.luv2code.springdemo.Coach;

import com.example.luv2code.springdemo.PredictionService.GamePredictionService;

public class BasketballCoach implements Coach {

    private GamePredictionService gamePredictionService;

    public BasketballCoach() { }

    public BasketballCoach(GamePredictionService theGamePredictionService) {
        gamePredictionService = theGamePredictionService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run up and down the court.";
    }

    @Override
    public String getGamePrediction() {
        return gamePredictionService.getGamePrediction();
    }

    @Override
    public String getInfo() {
        return null;
    }
}
