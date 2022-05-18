package com.example.minitestfinal.controller;


import com.example.minitestfinal.model.City;
import com.example.minitestfinal.model.Nationality;
import com.example.minitestfinal.service.city.ICityService;
import com.example.minitestfinal.service.nationality.INationalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/city")
@CrossOrigin("*")
public class CityController {
    @Autowired
    ICityService cityService;

    @Autowired
    INationalityService nationalityService;

    @ModelAttribute("nationalities")
    private Iterable<Nationality> nationalities(){
        return nationalityService.findAll();
    }

    @GetMapping
    public ResponseEntity<Iterable<City>> showAllCity(){
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> CreateCity(@RequestBody City city){
        return new ResponseEntity<>(cityService.save(city),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable Long id){
        Optional<City> cityOptional=cityService.findById(id);
        if (!cityOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityService.remove(id);
        return new ResponseEntity<>(cityOptional.get(),HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id,@RequestBody City city){
        Optional<City> cityOptional=cityService.findById(id);
        if (cityOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        city.setId(cityOptional.get().getId());
        return new ResponseEntity<>(cityService.save(city),HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findOne(@PathVariable Long id){
        return new ResponseEntity<>(cityService.findById(id).get(),HttpStatus.OK);
    }
}
