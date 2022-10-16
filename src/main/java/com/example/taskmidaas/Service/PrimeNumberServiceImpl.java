package com.example.taskmidaas.Service;

import com.example.taskmidaas.Model.AlgoUsed;
import com.example.taskmidaas.Model.UserData;
import com.example.taskmidaas.Repo.UserDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class PrimeNumberServiceImpl implements PrimeNumberService {

    /*
     * we are going through the range which is provided by the user and
     * adding all the prime numbers from that range to a list which is then
     * stored in UserData and also storing the time stamp and number of  prime no.
     * */
    @Autowired
    PrimeNumberGenerator generetor;
    @Autowired
    UserDataRepo repo;

    /*
     * generetor.isPrimeUsingLoop will return boolean value depending upon if the number is prime
     * */
    @Override
    public UserData primeNoUsingLoop(int a, int b,String userName){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=a;i<=b;i++){
            if (generetor.isPrimeUsingLoop(i)){
                list.add(i);
            }
        }
        UserData userData = new UserData();
        userData.setPrimeNumbers(list);
        userData.setDate(new Date());
        userData.setAlgo(AlgoUsed.UsingLoop);
        userData.setCount(list.size());
        userData.setUserName(userName);
        repo.save(userData);
        return userData;
    }

    /*
     * generetor.isPrimeUsingRecurrsion will return boolean value depending upon if the number is prime
     * */
    @Override
    public UserData primeNoUsingRecurrsion(int a, int b,String userName){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=a;i<=b;i++){
            if (generetor.isPrimeUsingRecurrsion(i,2)){
                list.add(i);
            }
        }
        UserData userData = new UserData();
        userData.setPrimeNumbers(list);
        userData.setDate(new Date());
        userData.setAlgo(AlgoUsed.UsingRecurrsion);
        userData.setCount(list.size());
        userData.setUserName(userName);
        repo.save(userData);
        return userData;
    }

    @Override
    public List<UserData> getAll() {
        return repo.findAll();
    }
}
