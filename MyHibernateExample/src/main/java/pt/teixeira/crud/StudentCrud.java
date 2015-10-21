package pt.teixeira.crud;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import pt.teixeira.model.Student;
import pt.teixeira.persistence.HibernateUtil;

public class StudentCrud {
	
	private static final Session SESSION = HibernateUtil.getSessionFactory().openSession();

	public static void createStudent(Student student) {
		SESSION.beginTransaction();
		SESSION.persist(student);
		SESSION.getTransaction().commit();
	}
	
	public static void updateStudent(Student student) {
		SESSION.beginTransaction();
		SESSION.update(student);
		SESSION.getTransaction().commit();
	}
	
	public static Student readStudentByName(String name) {
		SESSION.beginTransaction();
		String queryString = "FROM Student WHERE NAME = :qName";
		Query query = SESSION.createQuery(queryString).setString("qName", name);
		Student student = (Student) query.uniqueResult();
		return student;
	}
	
	public static List<Student> readeAllStudents() {
		SESSION.beginTransaction();
		String queryString = "FROM Student";
		Query query = SESSION.createQuery(queryString);
		@SuppressWarnings("unchecked")
		List<Student> students = query.list();
		return students;
	}
	
	public static void deleteStudent(Student student) {
		SESSION.beginTransaction();
		SESSION.delete(student);
		SESSION.getTransaction().commit();
	}
	
	public static void shutdown() {
		SESSION.close();
	}
	
}
