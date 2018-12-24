package com.sssm.springaop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sssm.springaop.dao.Dao1;

@Service
public class Business1 {

	@Autowired
	Dao1 dao1;

	public String getData() {
		return dao1.getData();
	}

}
