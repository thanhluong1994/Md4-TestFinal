package com.example.minitestfinal.service.nationality;


import com.example.minitestfinal.model.Nationality;
import com.example.minitestfinal.repo.INationalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NationalityService implements INationalityService {
    @Autowired
    private INationalityRepository nationalityRepository;
    @Override
    public Iterable<Nationality> findAll() {
        return nationalityRepository.findAll();
    }

    @Override
    public Optional<Nationality> findById(Long id) {
        return nationalityRepository.findById(id);
    }

    @Override
    public Nationality save(Nationality nationality) {
        return nationalityRepository.save(nationality);
    }

    @Override
    public void remove(Long id) {
        nationalityRepository.deleteById(id);
    }
}
