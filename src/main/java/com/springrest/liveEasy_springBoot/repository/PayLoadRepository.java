package com.springrest.liveEasy_springBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrest.liveEasy_springBoot.model.PayLoad;

@Repository
public interface PayLoadRepository extends JpaRepository<PayLoad,Long>{

}
