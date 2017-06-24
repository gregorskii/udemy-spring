package com.example.luv2code.springdemo.Coach;

import com.example.luv2code.springdemo.PredictionService.GamePredictionService;
import org.springframework.beans.factory.annotation.Value;

public class TennisCoach implements Coach {

    private GamePredictionService predictionService;

    @Value("${EMAIL}")
    private String email;

    public TennisCoach() { }

    public TennisCoach(GamePredictionService thePredictionService) {
        predictionService = thePredictionService;
    }

    @Override
    public String getDailyWorkout() {
        return "Hit some balls.";
    }

    public String getGamePrediction() {
        return predictionService.getGamePrediction();
    }

    @Override
    public String getInfo() {
        return String.format("Hi I am your coach, my email is %s.", email);
    }
}
