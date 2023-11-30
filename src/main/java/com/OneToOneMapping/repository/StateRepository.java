package com.OneToOneMapping.repository;

import com.OneToOneMapping.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository <State,Long> {

}
