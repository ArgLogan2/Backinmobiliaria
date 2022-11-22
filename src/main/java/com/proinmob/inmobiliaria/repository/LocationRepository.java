package com.proinmob.inmobiliaria.repository;
import com.proinmob.inmobiliaria.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location, Long>{
}