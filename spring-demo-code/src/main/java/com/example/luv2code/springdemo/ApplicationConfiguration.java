package com.example.luv2code.springdemo;

import com.example.luv2code.springdemo.Coach.BasketballCoach;
import com.example.luv2code.springdemo.Coach.Coach;
import com.example.luv2code.springdemo.Coach.TennisCoach;
import com.example.luv2code.springdemo.PredictionService.GamePredictionService;
import com.example.luv2code.springdemo.PredictionService.HappyGamePredictionService;
import com.example.luv2code.springdemo.PredictionService.SadGamePredictionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @ComponentScan("com.example.luv2code.springdemo"), property component scanning
@PropertySource("application.properties")
public class ApplicationConfiguration {

    @Bean
    public GamePredictionService happyGamePredictionService() {
        return new HappyGamePredictionService();
    }

    @Bean
    public GamePredictionService sadGamePredictionService() {
        return new SadGamePredictionService();
    }

    @Bean
    public Coach tennisCoach() {
        return new TennisCoach();
    }

    @Bean
    public Coach tennisCoach(@Qualifier("sadGamePredictionService") GamePredictionService predictionService) {
        return new TennisCoach(sadGamePredictionService());
    }

    @Bean
    public Coach basketBallCoach() {
        return new BasketballCoach();
    }

    @Bean
    public Coach basketBallCoach(@Qualifier("sadGamePredictionService") GamePredictionService predictionService) {
        return new BasketballCoach(sadGamePredictionService());
    }
}
