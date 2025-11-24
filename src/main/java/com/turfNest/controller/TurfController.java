package com.turfNest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.turfNest.entity.BookedTurf;
import com.turfNest.entity.Owner;
import com.turfNest.entity.Turff;
import com.turfNest.service.TurfService;
import com.turfNest.user.repository.BookRepo;
import com.turfNest.user.repository.OwnerRepo;

import java.net.http.HttpResponse;
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
    public Turff updateTurf(@PathVariable Long id, @RequestBody  Turff turf) {
        return turfService.updateTurf(id, turf);
    }
    
    @DeleteMapping("/{id}")
    public void deleteTurf(@PathVariable Long id) {
        turfService.deleteTurf(id);
    }
    
    @PostMapping("/Booked")
    public void Book(@RequestBody BookedTurf b1)
    {
    	turfService.addBook(b1);
    }
    @GetMapping("/BookedTurf")
    public List<BookedTurf> getBooking()
    {
    	return turfService.getAllBookedTurf();
    }
    @GetMapping("/search")
    public ResponseEntity<List<Turff>> search(@RequestParam String Keyword) throws Exception
    {
    	List<Turff> turff = turfService.searchTurf(Keyword);
    	return new ResponseEntity<>(turff,HttpStatus.OK);
    }
    
}
