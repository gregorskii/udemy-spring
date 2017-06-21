package com.luv2code;

public class CricketCoach implements Coach {
    private FortuneService fortuneService;

    public CricketCoach() { }

    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Hit the ball with the thing.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
