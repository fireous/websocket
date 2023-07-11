package com.test.websocket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.websocket.entity.TestBean;

@Repository
public interface TestDao extends JpaRepository<TestBean, Integer>{

}
