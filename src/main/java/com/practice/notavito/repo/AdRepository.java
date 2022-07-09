package com.practice.notavito.repo;

import org.springframework.data.repository.CrudRepository;

import com.practice.notavito.models.Ad;

public interface AdRepository extends CrudRepository<Ad, Long> {
    
}
