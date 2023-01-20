package com.we2foodie.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.we2foodie.web.model.ResourceDTO;
import com.we2foodie.web.model.Resources;
import com.we2foodie.web.repository.ResourceDataRepository;

@Service
public class LoadResourcesImpl implements LoadResources {
	
	@Autowired
	ResourceDataRepository resourceDataRepository;

	@Override
	public Resources getMainImage(String imagepath) {
		return resourceDataRepository.findByName(imagepath);
		 
	}

}
