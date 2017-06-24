package com.example.luv2code;

import com.example.luv2code.springdemo.Coach.Coach;
import com.example.luv2code.springdemo.ApplicationConfiguration;
import com.example.luv2code.springdemo.Coach.TennisCoach;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringDemoCodeApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(ApplicationConfiguration.class);

        SpringApplication.run(SpringDemoCodeApplication.class, args);

        // TennisCoach coach = context.getBean("tennisCoach", TennisCoach.class);
        Coach coach = context.getBean("basketBallCoach", Coach.class);

        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getGamePrediction());
        // System.out.println(coach.getInfo());
    }
}
