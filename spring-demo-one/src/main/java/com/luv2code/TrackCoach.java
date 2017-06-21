package com.luv2code;

public class TrackCoach implements Coach {

    private FortuneService fortuneService;

    public TrackCoach() { }

    public TrackCoach(FortuneService theFortuneService) {
        this.fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Run around the track for 2 hours.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
