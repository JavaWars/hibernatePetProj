package orm_test.db;

import java.util.List;

interface DAO<T> {
	
	public void add(T element);
	public void update(T element);
	public List<T> list();
	public T getById(int id);
	public void remove(int id);

}
