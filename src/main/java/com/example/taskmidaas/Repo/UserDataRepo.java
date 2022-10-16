package com.example.taskmidaas.Repo;

import com.example.taskmidaas.Model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepo extends JpaRepository<UserData,Integer> {
}
