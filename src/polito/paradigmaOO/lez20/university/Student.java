package polito.paradigmaOO.lez20.university;

public class Student {
	private int ID;
	private String first;
	private String last;
	private Course[] courses;

	public Student(int ID, String first, String last) {
		super();
		this.ID = ID;
		this.first = first;
		this.last = last;
		courses = new Course[University.MAX_COURSES_PER_STUDENT];
	}
	
	public void enroll(Course c) {
		for (int i = 0; i < courses.length; i++) {
			if (courses[i] == null) {
				courses[i] = c;
				break;//esce dal for
			}
		}
	}
	
	public String courses() {
		StringBuffer result = new StringBuffer();
		for (Course c : courses) {
			if (c != null)
				result.append(c).append("\n");
		}

		return result.toString();
	}


	@Override
	public String toString() {
		return ID + " " + first + " " + last;
	}


}
