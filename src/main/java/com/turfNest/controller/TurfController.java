package com.turfNest.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turfNest.entity.Turff;
import com.turfNest.service.TurfService;

import java.util.List;

@RestController
@RequestMapping("/api/turfs")
public class TurfController {

    @Autowired
    private TurfService turfService;


    @GetMapping
    public List<Turff> getAllTurfs() {
        return turfService.getAllTurfs();
    }
    
    
    @PostMapping
    public Turff createTurf(@RequestBody Turff turf) {
        return turfService.addTurf(turf);
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
