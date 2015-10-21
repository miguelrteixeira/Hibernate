package pt.teixeira;

import java.text.ParseException;
import java.util.List;

import pt.teixeira.crud.StudentCrud;
import pt.teixeira.model.Student;

public class App {
	
	public static void main (String[] args) throws ParseException {
		
		Student student1 = new Student("Miguel Teixeira", "08-10-1988", "Masters Student", 17.7);
		Student student2 = new Student("Pedro Teixeira", "25-05-1994", "Degree Student", 17.2);
		Student student3 = new Student("Maria Teixeira", "13-04-1998", "Junior Student", 16.9);
		
		/*Run MySQL*/
		StudentCrud.createStudent(student1);
		StudentCrud.createStudent(student2);
		
		student2.setStudentName("Pedro R Teixeira");
		StudentCrud.updateStudent(student2);
		
		Student student4 = StudentCrud.readStudentByName("Pedro R Teixeira");
		System.out.println(student4);
		
		List<Student> listOfStudents1 = StudentCrud.readeAllStudents();
		for (Student student : listOfStudents1) {
			System.out.println(student);
		}
		
		StudentCrud.deleteStudent(student1);
		
		List<Student> listOfStudents2 = StudentCrud.readeAllStudents();
		for (Student student : listOfStudents2) {
			System.out.println(student);
		}
		
		StudentCrud.createStudent(student3);
		
		List<Student> listOfStudents3 = StudentCrud.readeAllStudents();
		for (Student student : listOfStudents3) {
			System.out.println(student);
		}
		
		StudentCrud.shutdown();
	}
	
}
