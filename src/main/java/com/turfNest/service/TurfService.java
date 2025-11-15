package com.turfNest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turfNest.entity.Turff;
import com.turfNest.user.repository.TurfRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TurfService {

    @Autowired
    private TurfRepository turfRepository;

    // Get all turfs
    public List<Turff> getAllTurfs() {
        return turfRepository.findAll();
    }

    // Add a new Turf
    public Turff addTurf(Turff turf) {
        return turfRepository.save(turf);
    }

    // Get a Turf by ID
    public Turff getTurfById(Long id) {
        Optional<Turff> turf = turfRepository.findById(id);
        return turf.orElseThrow(() -> new RuntimeException("Turf not found"));
    }

    // Update an existing Turf
    public Turff updateTurf(Long id, Turff turf) {
        if (turfRepository.existsById(id)) {
            turf.setId(id);
            return turfRepository.save(turf);
        } else {
            throw new RuntimeException("Turf not found for update");
        }
    }

    // Delete a Turf
    public void deleteTurf(Long id) {
        if (turfRepository.existsById(id)) {
            turfRepository.deleteById(id);
        } else {
            throw new RuntimeException("Turf not found for deletion");
        }
    }
}
