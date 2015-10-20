package pt.teixeira;

import java.text.ParseException;

import org.hibernate.Session;

import pt.teixeira.model.Student;
import pt.teixeira.persistence.HibernateUtil;

public class App {
	
	public static void main (String[] args) throws ParseException {
		
		Student student1 = new Student("Miguel Teixeira", "08-10-1988", "Masters Student", 17.7);
		Student student2 = new Student("Pedro Teixeira", "25-05-1994", "Degree Student", 17.2);
		
		/*Print created students*/
		System.out.println(student1);
		System.out.println(student2);
		
		/*Run MySQL*/
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		session.persist(student1);
		session.persist(student2);
		
		session.getTransaction().commit();
		
		session.close();
	}
	
}
