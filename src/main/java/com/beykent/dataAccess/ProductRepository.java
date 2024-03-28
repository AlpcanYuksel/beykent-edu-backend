package com.beykent.dataAccess;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beykent.entities.concretes.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
