package com.example.minitestfinal.repo;


import com.example.minitestfinal.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepository extends PagingAndSortingRepository<City,Long> {
Page<City> findAllByName(String name, Pageable pageable);
}
