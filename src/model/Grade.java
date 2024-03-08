package model;

public class Grade {
	// variables
	private long gID;
	private int value;
	private Student student;
	private Course course;
	
	private static long counter = 200000;

	
	// getters and setters 
	public long getgID() {
		return gID;
	}

	public void setgID() {
		this.gID = counter;
		counter++;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		if (value <= 10 && value > 0)
			this.value = value;
		else
			this.value = 0;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		if(student  != null)
			this.student = student;
		else
			this.student = new Student();
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		if(course  != null)
			this.course = course;
		else
			this.course = new Course();
	}

	
	
	// constructors 
		 public Grade() {
			 setgID();
			 setValue(0);
			 setStudent(new Student());
			 setCourse(new Course());
			 
		 }
		 
		 public Grade(int value, Student student, Course course)
		 {
			 setgID();
			 setValue(value);
			 setStudent(student);
			 setCourse(course);
		 }
		 
		 
	//toString
	
		 public String toString() { 
			 return gID + ": " + student.getName().charAt(0) + " " + student.getSurname() + ": " + value + " {" + course + "}";
		 }
		 
		 
	// other functions
	

	
	
}
