package com.one9.dao;


import com.one9.model.CurrentUserSession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionDAO extends JpaRepository<CurrentUserSession, Integer> {
    public CurrentUserSession findByUuid(String uuid);
    public CurrentUserSession findByUserId(String userId);
   // public CurrentUserSession findByMobileNumber(String uuid);
}
