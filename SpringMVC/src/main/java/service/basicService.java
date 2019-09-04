package service;

import java.util.List;

import model.City;


public interface basicService<T> {
	
		public int selectCount(String txt);

		public List<T> select(String txt,String limit);
		
		public Integer insert(T c );
		
		public Integer delete(Integer id);
		
		public Integer update(T c);
		
		public T selectById(Integer id);
}
