package com.turfNest.user.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.turfNest.entity.Turff;

@Repository
public interface TurfRepository extends JpaRepository<Turff,Long> {
	@Query("SELECT t FROM Turff t WHERE " +
		       "LOWER(t.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
		       "LOWER(t.location) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
		       "STR(t.pricePerHour) LIKE CONCAT('%', :keyword, '%') OR " +
		       "STR(t.availableSlots) LIKE CONCAT('%', :keyword, '%')")
		List<Turff> searchTurf(@Param("keyword") String keyword);


}
