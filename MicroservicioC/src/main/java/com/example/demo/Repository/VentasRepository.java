package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Ventas;
@Repository
public interface VentasRepository extends JpaRepository<Ventas, Integer>{

}
