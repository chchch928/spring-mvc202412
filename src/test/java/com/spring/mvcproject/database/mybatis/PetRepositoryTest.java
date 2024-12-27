package com.spring.mvcproject.database.mybatis;

import com.spring.mvcproject.database.mybatis.entity.Pet;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PetRepositoryTest {
    @Autowired
    PetRepository petRepository;

    @Test
    void saveTest(){
        Pet pet = Pet.builder()
                .petName("보리")
                .petAge(3)
                .injection(true)
                .build();

        petRepository.save(pet);
    }
    @Test
    void findByIdTest(){
        Pet foundPet = petRepository.findById(2L);
        System.out.println("foundPet = "+ foundPet);
    }

    @Test
    void findAllTest(){
        List<Pet> pets = petRepository.findAll();
        System.out.println("================ List of pet ================");
        pets.forEach(System.out::println);
    }

    @Test
    void deleteTest(){
        Long id = 1L;
        petRepository.deleteById(id);

        Pet pet = petRepository.findById(id);
        System.out.println("pet = "+ pet);
    }
    @Test
    void countTest(){

        int count = petRepository.petCount();
        System.out.println("count = " + count);
    }

}