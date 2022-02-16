package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.componentes.Disco;

@Repository
public interface DiscoRepo extends JpaRepository<Disco, Long>{

}
