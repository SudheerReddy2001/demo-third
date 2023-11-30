package com.OneToOneMapping.repository;

import com.OneToOneMapping.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository <Country,Long> {

}
