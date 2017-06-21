package com.luv2code;

public class WaterPoloCoach implements Coach {

    private FortuneService fortuneService;

    public WaterPoloCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 12 laps with ball.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
