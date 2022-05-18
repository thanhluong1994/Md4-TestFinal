package com.example.minitestfinal.repo;

import com.example.minitestfinal.model.Nationality;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface INationalityRepository extends PagingAndSortingRepository<Nationality,Long> {
}
