package orm_test.lololo;

import java.util.HashSet;

import org.hibernate.Session;
import org.hibernate.Transaction;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import orm_test.data.Subject;
import orm_test.data.Teacher;
import orm_test.hibernateUtil.HibernateUtil;

public class AppTest 
    extends TestCase
{
    public AppTest( String testName )
    {
        super( testName );
    }

    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    public void testApp()
    {
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
        assertTrue( true );
    }
}
