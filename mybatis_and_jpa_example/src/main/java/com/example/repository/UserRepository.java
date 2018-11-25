package com.example.repository;

import com.example.bean.question.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by niejun on 2018/11/25 10:15
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
