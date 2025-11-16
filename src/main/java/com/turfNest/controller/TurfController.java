package com.turfNest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.turfNest.entity.Owner;
import com.turfNest.entity.Turff;
import com.turfNest.service.TurfService;
import com.turfNest.user.repository.OwnerRepo;

import java.util.List;

@RestController
@RequestMapping("/api/turfs")
public class TurfController {

    @Autowired
    private TurfService turfService;
    @Autowired
    private OwnerRepo ownerRepo;
  
    @GetMapping
    public List<Turff> getAllTurfs() {
        return turfService.getAllTurfs();
    }

  
    @PostMapping
    public Turff createTurf(@RequestBody Turff turf) {
        return turfService.addTurf(turf);
    }
  
   @PostMapping("/OwnerTurffAdd")
   public Owner OwnerAddTurf(@RequestBody Owner o1)
   {
	   return ownerRepo.save(o1);
   }

    @GetMapping("/{id}")
    public Turff getTurfById(@PathVariable Long id) {
        return turfService.getTurfById(id);
    }

    
    @PutMapping("/{id}")
    public Turff updateTurf(@PathVariable Long id, @RequestBody Turff turf) {
        return turfService.updateTurf(id, turf);
    }

  
    @DeleteMapping("/{id}")
    public void deleteTurf(@PathVariable Long id) {
        turfService.deleteTurf(id);
    }
}
