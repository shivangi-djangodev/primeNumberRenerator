package com.example.taskmidaas.Controller;

import com.example.taskmidaas.Model.UserData;
import com.example.taskmidaas.Repo.UserDataRepo;
import com.example.taskmidaas.Service.PrimeNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api")

public class PrimeNumberController {
    @Autowired
    PrimeNumberService primeNumberService;
    @Autowired
    UserDataRepo repo;
    /*
    * UsingLoop api is used for calling prime Number generator method from service
    * */
    @PutMapping("/usingLoop")
    public UserData generatePrimeUsingLoop(@RequestParam int var1,@RequestParam int var2,@RequestParam String userName){
        return primeNumberService.primeNoUsingLoop(var1,var2,userName);
    }
    /*
     * allData used for returning the data of all user
     * */
    @GetMapping("/allData")
    public List<UserData> allData(){
        return primeNumberService.getAll();
    }
    /*
     * UsingRecurrsion api is used for calling prime Number generator method from service
     * */
    @PutMapping("/usingRecurrsion")
    public UserData generateUsingRecurrsion(@RequestParam int var1,@RequestParam int var2,@RequestParam String userName){
        return primeNumberService.primeNoUsingRecurrsion(var1,var2,userName);
    }

}
