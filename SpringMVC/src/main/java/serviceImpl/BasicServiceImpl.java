package serviceImpl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import model.City;
import service.basicService;

@Service
public class BasicServiceImpl<T> implements basicService<T> {

	private Object execDao(String mname, Object... objs) {
		try {
			Field f =this.getClass().getDeclaredField("dao");
			f.setAccessible(true);
			Object dao = f.get(this);
			
			Class cls =dao.getClass();  //dao的字节码（类描述对象）
			Class[] cs = new Class[objs.length];
			for (int i = 0; i < objs.length; i++)
				cs[i] = objs[i].getClass();
			Method m = cls.getMethod(mname, cs);
			m.setAccessible(true);
			return m.invoke(dao, objs);
		} catch (Exception e) {
			return null;
		}
	}

	public List<T> select(String txt) {
		Object o = execDao("select", txt);
		if (o != null)
			return (List<T>) o;
		else
			return new ArrayList<T>();
	}

	public T selectById(Integer id) {
		Object o = execDao("selectById",id);
		if (o != null)
			return (T) o;
		else
			return null;
	}

	public Integer delete(Integer id) {
		Object o = execDao("delete", id);
		if (o != null)
			return (Integer) o;
		else
			return -2;
	}

	public Integer insert(T t) {
		Object o = execDao("insert", t);
		if (o != null)
			return (Integer) o;
		else
			return -2;
	}

	public Integer update(T t) {
		Object o = execDao("update", t);
		if (o != null)
			return (Integer) o;
		else
			return -2;
	}

}
