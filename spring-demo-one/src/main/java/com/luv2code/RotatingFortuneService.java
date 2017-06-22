package com.luv2code;

public class RotatingFortuneService implements FortuneService {

    private String[] fortunes = {
        "Good fortune awaits!",
        "You will see something great today.",
        "You will land in a pile of money."
    };

    @Override
    public String getFortune() {
        Integer randomNum = (int)(Math.random() * fortunes.length);
        return fortunes[randomNum];
    }
}
