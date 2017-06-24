package com.luv2code;

import com.luv2code.springdemo.TennisCoach;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringDemoAnnotationsApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
            new ClassPathXmlApplicationContext("context.xml");

        SpringApplication.run(SpringDemoAnnotationsApplication.class, args);

        TennisCoach coach = context.getBean("tennisCoach", TennisCoach.class);

        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getGamePrediction());
        System.out.println(coach.getCoachInfo());

        // Tests scope

        TennisCoach alphaCoach = context.getBean("tennisCoach", TennisCoach.class);

        boolean result = (coach == alphaCoach);

        System.out.println("Pointing to the same object: " + result);
        System.out.println("Memory for coach: " + coach);
        System.out.println("Memory for alphaCoach: " + alphaCoach);
    }
}
