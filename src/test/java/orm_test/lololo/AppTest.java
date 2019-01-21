package orm_test.lololo;

import java.util.HashSet;

import javax.transaction.Transaction;

import org.hibernate.Session;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import orm_test.lololo.data.User;
import orm_test.lololo.hibernateUtil.HibernateUtil;

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
    	org.hibernate.Transaction t=null;
		try {
			t=session.beginTransaction();
			User u=new User("name1");
			
			session.save(u);
			t.commit();
		} finally {
			
			session.close();
		}
		System.out.println("testing finished");

        assertTrue( true );
    }
}
