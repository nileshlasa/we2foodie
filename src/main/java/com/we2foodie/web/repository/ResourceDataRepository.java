package com.we2foodie.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.we2foodie.web.model.ResourceDTO;
import com.we2foodie.web.model.Resources;

@Repository
public interface ResourceDataRepository extends JpaRepository<Resources, Integer> {

	 Resources findByName(String imagepath);
}
