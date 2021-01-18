package com.dwes.restexample.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dwes.restexample.entities.Product;



public interface ProductRepository extends JpaRepository<Product, Integer> {

}