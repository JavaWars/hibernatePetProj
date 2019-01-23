package orm_test.db;

import java.util.List;

import org.hibernate.Session;

import orm_test.data.Subject;
import orm_test.hibernateUtil.HibernateUtil;

public class SubjectDAO implements DAO<Subject>{

	public void add(Subject element) {
		Session s=HibernateUtil.getSession();
		s.persist(element);
	}

	public void update(Subject element) {
		Session s=HibernateUtil.getSession();
		s.update(element);
	}

	public List<Subject> list() {
		List<Subject> l=HibernateUtil.getSession().createQuery("from subject").list();
		return l;
	}

	public Subject getById(int id) {
		Session s=HibernateUtil.getSession();
		return (Subject) s.load(Subject.class, id);
	}

	public void remove(int id) {
		Session s=HibernateUtil.getSession();
		Subject subject = (Subject) s.load(Subject.class, new Integer(id));
		s.delete(subject);
	}
	
	

}
