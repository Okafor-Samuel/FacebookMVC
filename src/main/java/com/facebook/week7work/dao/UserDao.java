package com.facebook.week7work.dao;


import com.facebook.week7work.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<Users,Integer> {

    Users findByEmail(String email);

    @Query(value = "SELECT full_name,id  FROM users q ORDER BY q.id",nativeQuery = true)
    List<Users> fetchUser();
}
