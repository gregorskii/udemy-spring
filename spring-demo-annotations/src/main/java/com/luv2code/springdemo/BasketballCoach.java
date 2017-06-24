package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class BasketballCoach implements Coach {

    private GamePredictionService predictionService;

    @Autowired
    public BasketballCoach(@Qualifier("sadGamePrediction") GamePredictionService thePredictionService) {
        predictionService = thePredictionService;
    }

    @Override
    public String getDailyWorkout() {
        return "Dribble lots.";
    }

    @Override
    public String getGamePrediction() {
        return predictionService.getGamePrediction();
    }
}
