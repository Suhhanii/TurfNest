package com.turfNest.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.turfNest.entity.BookedTurf;

@Repository
public interface BookRepo extends JpaRepository<BookedTurf, Integer> {

}
