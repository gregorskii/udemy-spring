package com.luv2code;

public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "You will win today.";
    }
}
