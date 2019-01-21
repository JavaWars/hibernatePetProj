package orm_test;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import orm_test.lololo.data.Subject;
import orm_test.lololo.data.Teacher;
import orm_test.lololo.hibernateUtil.HibernateUtil;

public class App {

	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Subject sub1=new Subject("Math","This is a mother of all thiencesa",32);
			Subject sub2=new Subject("PE","Sport is coolsa",20);
			
			session.persist(sub2);
			session.persist(sub1);
			
			HashSet<Subject> teacher_subjects=new HashSet<Subject>();
			teacher_subjects.add(sub1);
			teacher_subjects.add(sub2);
			
			Teacher t=new Teacher( "Ivan 1", "Petrov 2", teacher_subjects);
			session.persist(t);
			tx.commit();
		} finally {
			
			session.close();
		}
		System.out.println("finished");
	}
}
