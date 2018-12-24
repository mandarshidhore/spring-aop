package com.sssm.springaop.dao;

import org.springframework.stereotype.Repository;

@Repository
public class Dao2 {

	public String getData() {
		return "Dao2";
	}

	public String getExceptionDuringDataRetrieve() {
		throw new RuntimeException("++++ Runtime Exception ++++");
	}

}
