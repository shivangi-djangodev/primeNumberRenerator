package com.example.taskmidaas;

import com.example.taskmidaas.Model.UserData;
import com.example.taskmidaas.Service.PrimeNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class TaskMidaasApplication implements CommandLineRunner {
    @Autowired
    PrimeNumberService primeNumberService;

    public static void main(String[] args) {
        SpringApplication.run(TaskMidaasApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        boolean whileExit = true;
        while (whileExit){
            System.out.println("Chose Algo");
            System.out.println("1 for using Loop");
            System.out.println("2 for using Recurrsion");
            System.out.println("3 display all data");
            System.out.println("4 for Exit");
            int p = scanner.nextInt();
            switch (p){
                case 1:
                    System.out.println("Enter Name");
                    String s = scanner.next();
                    System.out.println("Enter Starting point");
                    int a = scanner.nextInt();
                    System.out.println("Enter End point");
                    int b = scanner.nextInt();
                    primeNumberService.primeNoUsingLoop(a,b,s);
                    break;
                case 2:
                    System.out.println("Enter Name");
                    String s1 = scanner.next();
                    System.out.println("Enter Starting point");
                    int a1 = scanner.nextInt();
                    System.out.println("Enter End point");
                    int b1 = scanner.nextInt();
                    primeNumberService.primeNoUsingRecurrsion(a1,b1,s1);
                    break;
                case 3:
                    List<UserData> i =primeNumberService.getAll();
                    for (UserData userData:i){
                        System.out.println(userData);
                    }
                    break;
                case 4:
                    whileExit = false;
                    break;
                default:
                    System.out.println("Incorrect option");
                    break;
            }
            if (p==3){
                break;
            }
        }
    }
}
