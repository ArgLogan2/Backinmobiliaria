package com.proinmob.inmobiliaria.repository;
import com.proinmob.inmobiliaria.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Long>{
}
