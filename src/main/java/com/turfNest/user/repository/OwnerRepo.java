package com.turfNest.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turfNest.entity.Owner;
import com.turfNest.entity.Turff;

@Repository
public interface OwnerRepo extends JpaRepository<Owner,Long> {

}
