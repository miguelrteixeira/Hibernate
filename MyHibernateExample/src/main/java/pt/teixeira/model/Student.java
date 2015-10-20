package pt.teixeira.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/** INFO 
 * GenerationType.AUTO: detects automatically how to generate the primary keys
 * GenerationType.IDENTITY: for MySQL databases
 * GenerationType.SEQUENCE: for Oracle databases
 * GenerationType.TABLE: primary keys are assigned using an underlying database table
 * 
 * Transient: Attribute is not persisted to database
 * Temporal: define a date, time or timestamp var in database
 */

@Entity
@Table (name = "STUDENTS")
public class Student {

	/* Attributes */
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column (name = "ID")
	private int Id;

	@Column (name = "NAME", nullable = false)
	private String studentName;

	@Temporal(TemporalType.DATE)
	@Column (name = "YEAR")
	private Date yearBorn;

	@Column (name = "DESCRIPTION")
	private String studentDescription;

	@Transient
	private double averageScore;

	/* Constructors */
	public Student(String studentName, String yearBorn, String studentDescription, double averageScore) throws ParseException {
		super();
		this.studentName = studentName;
		setYearBorn(yearBorn);
		this.studentDescription = studentDescription;
		this.averageScore = averageScore;
	}

	/* Getters and Setters */
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Date getYearBorn() {
		return yearBorn;
	}

	public void setYearBorn(String yearBorn) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy");
		this.yearBorn = sdf.parse(yearBorn);
	}

	public String getStudentDescription() {
		return studentDescription;
	}

	public void setStudentDescription(String studentDescription) {
		this.studentDescription = studentDescription;
	}

	public double getAverageScore() {
		return averageScore;
	}

	public void setAverageScore(double averageScore) {
		this.averageScore = averageScore;
	}

	/* Overrides */
	@Override
	public String toString() {
		return "--> Student Data <--" + 
			   "\nStudent Name: " + this.studentName + 
			   "\nStudent Birthday: " + this.yearBorn + 
			   "\nStudent Description: " + this.studentDescription + 
			   "\nStudent Average Score: " + this.averageScore + "\n";
	}

}
