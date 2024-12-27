package com.spring.mvcproject.database.mybatis;

import com.spring.mvcproject.database.mybatis.entity.Pet;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// CRUD 정의
@Mapper
public interface PetRepository {
    //CREATE
    boolean save(Pet pet);

    //READ - Single Matching
    Pet findById(Long id);

    //READ - Multiple Matching
    List<Pet> findAll();

    // UPDATE
    boolean updatePet (Pet pet);

    //DELETE
    boolean deleteById(Long id);

    // READ - Count
    int petCount();

}
