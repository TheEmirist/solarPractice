package com.practice.notavito.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.practice.notavito.models.Ad;

public interface AdRepository extends CrudRepository<Ad, Long> {
    List<Ad> findByTag(String tag);
}
