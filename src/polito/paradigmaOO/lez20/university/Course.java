package polito.paradigmaOO.lez20.university;

public class Course {

	private int code;
	private String teacher;
	private String title;

	private Student[] students;

	public Course(int code, String teacher, String title) {
		this.code = code;
		this.teacher = teacher;
		this.title = title;
		students = new Student[University.MAX_STUDENT_PER_COURSES];

	}

	public void enroll(Student s) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = s;
				break;// esce dal for
			}
		}
	}

	public String attendees() {
		StringBuffer result = new StringBuffer();
		for (Student s : students) {
			if (s != null)
				result.append(s).append("\n");
		}

		return result.toString();
	}

	@Override
	public String toString() {
		return code + " " + teacher + " " + title;
	}

}
