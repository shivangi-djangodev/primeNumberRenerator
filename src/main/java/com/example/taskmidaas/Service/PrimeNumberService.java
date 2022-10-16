package com.example.taskmidaas.Service;

import com.example.taskmidaas.Model.UserData;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PrimeNumberService {
    UserData primeNoUsingLoop(int a, int b, String userName);
    UserData primeNoUsingRecurrsion(int a,int b,String userName);

    List<UserData> getAll();
}
