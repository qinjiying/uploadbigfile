package org.demo.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BaseDao <T,V> {
		
		List<V> getList(T t);
		
		Integer save(T t);
		
		Integer update(T t);
		
		Integer delete(T t);
		
		Integer getCount(T t);
		
		V get(T t);

}
