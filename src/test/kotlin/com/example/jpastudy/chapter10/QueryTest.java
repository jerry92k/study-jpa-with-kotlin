package com.example.jpastudy.chapter10;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class QueryTest {

	@Autowired
	EntityManager em;

	@Test
	void test(){
		Query query = em.createQuery("select m.username, m.age from Member as m where m.username ='gigi'");
		List resultList = query.getResultList();
		Object[] result = (Object[])resultList.get(0);
		String username = result[0].toString();

	}
}
