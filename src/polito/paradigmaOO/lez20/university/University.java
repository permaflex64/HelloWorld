package polito.paradigmaOO.lez20.university;

import java.io.BufferedReader;

//import polito.paradigmaOO.lez23.generici.step1.Studente;

public class University {
	private String name;
	private String rector;
	
	public static final int MAX_STUDENTS = 1000;
	public static final int MAX_COURSES = 50;

	public static final int MAX_STUDENT_PER_COURSES = 100;
	public static final int MAX_COURSES_PER_STUDENT = 25;
	
	public static final int INITIAL_ID = 10000;
	public static final int INITIAL_CODE = 10;
	
	private Student[] include;
	private int nextId = INITIAL_ID;

	private Course[] offers;
	private int nextCode = INITIAL_CODE;
	
	
	
	public University(String name) {
		this.setName(name);
		this.include = new Student[MAX_STUDENTS];
		this.offers = new Course[MAX_COURSES];
	}
	
	public int enroll(String first, String last) {
		Student studente = new Student(nextId, first, last);
		include[nextId-INITIAL_ID] = studente;
		return nextId++;
	}

	public String studente(int id) {
		Student s = include[id-INITIAL_ID];
		return s.toString();
	}
	
	public int activate(String teacher, String title) {
		Course c = new Course(nextCode, teacher, title);
		offers[nextCode-INITIAL_CODE] = c;
		return nextCode++;
	}
	
	public String course(int code) {
		Course c = offers[code-INITIAL_CODE];
		return c.toString();
	}
	
	public void register(int studentID, int courseCode) {
		Student s = include[studentID-INITIAL_ID];
		Course c = offers[courseCode-INITIAL_CODE];

		s.enroll(c);
		c.enroll(s);
	}
	
	public String listAttenders(int courseCode) {
		Course c = offers[courseCode-INITIAL_CODE];
		return c.attendees();
	}
	
	public String studyPlan(int studentID) {
		Student s = include[studentID-INITIAL_ID];
		return s.courses();
	}
	
	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	public void setRector(String first, String last) {
		StringBuffer buff = new StringBuffer();
		this.rector = buff.append(first).append(" ").append(last).toString();
	}

	public String getRector() {
		return rector;
	}

}
