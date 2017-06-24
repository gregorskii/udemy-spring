package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// @Component("tennisCoach")
@Component // default bean ID will be tennisCoach
// @Scope("prototype") // scope, default is singleton
public class TennisCoach implements Coach {

    // @Autowired will autowire fields, but not recommended
    private GamePredictionService predictionService;

    @Value("${EMAIL}")
    private String email;

    public TennisCoach() { }

    @PostConstruct
    public void init() {
        System.out.println("INIT");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("DESTROY");
    }

    // @Autowired
    // public TennisCoach(@Qualifier("sadGamePrediction") GamePredictionService thePredictionService) {
    //     predictionService = thePredictionService;
    // }

    @Override
    public String getDailyWorkout() {
        return "Run up and down the court.";
    }

    @Override
    public String getGamePrediction() {
        return predictionService.getGamePrediction();
    }

    @Autowired
    public void setPredictionService(@Qualifier("randomPropertyGamePrediction") GamePredictionService predictionService) {
        this.predictionService = predictionService;
    }

    public String getCoachInfo() {
        return String.format("My info is: %s", email);
    }
}
