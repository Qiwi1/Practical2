package com.example.demo.repo;

import com.example.demo.models.PostTwo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepositoryTwo extends CrudRepository<PostTwo, Long> {

    List<PostTwo> findByNazvanieContains(String nazvanie);

}
