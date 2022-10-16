package com.example.taskmidaas.Controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.example.taskmidaas.Model.AlgoUsed;
import com.example.taskmidaas.Model.UserData;
import com.example.taskmidaas.Repo.UserDataRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class PrimeNumberControllerTest {

    @MockBean
    private UserDataRepo repo;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void genratePrimeUsingLoopTest() throws Exception {

        Date date = new Date();
        UserData userData = new UserData();
        userData.setUserName("user12");
        userData.setCount(4);
        userData.setAlgo(AlgoUsed.UsingLoop);
        userData.setDate(date);
        userData.setId(1l);

        Mockito.when(repo.save(any(UserData.class))).thenReturn(userData);
        MvcResult i = this.mockMvc.perform(put("/api/usingLoop?var1=1&var2=10&userName=user12")).andDo(print()).
                andExpect(status().isOk()).andReturn();
        String s = i.getResponse().getContentAsString();
        UserData userDataResponce = new ObjectMapper().readValue(s, UserData.class);

        ArrayList<Integer> checkList = new ArrayList<>();
        checkList.add(2);
        checkList.add(3);
        checkList.add(5);
        checkList.add(7);

        assertThat(userDataResponce.getPrimeNumbers()).isNotNull();
        assertThat(userDataResponce.getUserName().equals("user12")).isTrue();
        assertThat(userDataResponce.getAlgo().equals(AlgoUsed.UsingLoop)).isTrue();
        assertThat(checkList.equals(userDataResponce.getPrimeNumbers())).isTrue();
    }

    @Test
    public void genrateUsingRecurrsionTest() throws Exception {

        Date date = new Date();
        UserData userData = new UserData();
        userData.setUserName("user12");
        userData.setCount(4);
        userData.setAlgo(AlgoUsed.UsingLoop);
        userData.setDate(date);
        userData.setId(1l);

        Mockito.when(repo.save(any(UserData.class))).thenReturn(userData);

        MvcResult i = this.mockMvc.perform(put("/api/usingRecurrsion?var1=1&var2=10&userName=user1")).andDo(print()).
                andExpect(status().isOk()).andReturn();
        String s = i.getResponse().getContentAsString();
        UserData userDataResponce = new ObjectMapper().readValue(s, UserData.class);

        ArrayList<Integer> checkList = new ArrayList<>();
        checkList.add(2);
        checkList.add(3);
        checkList.add(5);
        checkList.add(7);

        assertThat(userDataResponce.getPrimeNumbers()).isNotNull();
        assertThat(userDataResponce.getUserName().equals("user1")).isTrue();
        assertThat(userDataResponce.getAlgo().equals(AlgoUsed.UsingRecurrsion)).isTrue();
        assertThat(checkList.equals(userDataResponce.getPrimeNumbers())).isTrue();

    }

    @Test
    public void allDataTest() throws Exception {
        ArrayList<Integer> checkList = new ArrayList<>();
        checkList.add(2);
        checkList.add(3);
        checkList.add(5);
        checkList.add(7);
        Date date = new Date();
        UserData userData = new UserData();
        userData.setUserName("user12");
        userData.setCount(4);
        userData.setAlgo(AlgoUsed.UsingLoop);
        userData.setDate(date);
        userData.setId(1l);
        userData.setPrimeNumbers(checkList);

        ArrayList<Integer> checkList2 = new ArrayList<>();
        checkList2.add(11);
        checkList2.add(13);
        checkList2.add(17);
        checkList2.add(19);
        UserData userData2 = new UserData();
        userData2.setUserName("user12");
        userData2.setCount(4);
        userData2.setAlgo(AlgoUsed.UsingLoop);
        userData2.setDate(date);
        userData2.setId(1l);
        userData2.setPrimeNumbers(checkList);
        List<UserData> listUserData = new ArrayList<>();
        listUserData.add(userData);
        listUserData.add(userData2);

        Mockito.when(repo.findAll()).thenReturn(listUserData);

        MvcResult i = this.mockMvc.perform(get("/api/allData")).andDo(print()).
                andExpect(status().isOk()).andReturn();
        String s = i.getResponse().getContentAsString();
        List<UserData> userDataList = Arrays.asList(new ObjectMapper().readValue(s, UserData[].class));
        assertThat(userDataList.get(0).equals(userData)).isTrue();
        assertThat(userDataList.get(1).equals(userData2)).isTrue();
    }
}