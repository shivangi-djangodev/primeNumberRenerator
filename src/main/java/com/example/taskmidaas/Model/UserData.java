package com.example.taskmidaas.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Data
@Entity
@Table()
public class UserData {
    @Id
    @SequenceGenerator(name = "UserData_seq",sequenceName = "UserData_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "UserData_seq")
    private Long id;
    private String userName;
    private Date date;
    private AlgoUsed algo;
    private Integer count;
    @Lob
    private ArrayList<Integer> primeNumbers;

    @Override
    public String toString() {
        return "UserData{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", date=" + date +
                ", algo=" + algo +
                ", count=" + count +
                ", primeNumbers=" + primeNumbers +
                '}';
    }
}
