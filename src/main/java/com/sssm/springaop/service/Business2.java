package com.sssm.springaop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sssm.springaop.dao.Dao2;

@Service
public class Business2 {

	@Autowired
	Dao2 dao2;

	public String getData() {
		return dao2.getData();
	}

}
