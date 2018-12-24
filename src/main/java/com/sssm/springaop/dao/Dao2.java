package com.sssm.springaop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class Dao2 {

	public String getData() {
		// throw new RuntimeException("++++ Runtime Exception ++++");
		return "Dao2";
	}

}
