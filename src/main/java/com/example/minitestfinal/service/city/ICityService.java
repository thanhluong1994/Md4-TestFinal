package com.example.minitestfinal.service.city;

import com.example.minitestfinal.model.City;
import com.example.minitestfinal.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICityService extends IGeneralService<City> {
    Page<City> findAll(Pageable pageable);
    Page<City> findAllByName(String name,Pageable pageable);
}
