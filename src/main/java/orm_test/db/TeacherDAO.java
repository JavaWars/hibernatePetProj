package orm_test.db;

import java.util.List;

import org.hibernate.Session;

import orm_test.data.Teacher;
import orm_test.hibernateUtil.HibernateUtil;

public class TeacherDAO implements DAO<Teacher> {

	public void add(Teacher element) {
		Session s=HibernateUtil.getSession();
		s.persist(element);		
	}

	public void update(Teacher element) {
		Session s=HibernateUtil.getSession();
		s.update(element);		
	}

	public List<Teacher> list() {
		List<Teacher> l=HibernateUtil.getSession().createQuery("from teacher").list();
		return l;
	}

	public Teacher getById(int id) {
		Session s=HibernateUtil.getSession();
		return (Teacher) s.load(Teacher.class, id);
	}

	public void remove(int id) {
		Session s=HibernateUtil.getSession();
		Teacher subject = (Teacher) s.load(Teacher.class, new Integer(id));
		s.delete(subject);
	}

}
