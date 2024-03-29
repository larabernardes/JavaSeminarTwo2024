package service;

import java.util.ArrayList;
import java.util.Arrays;

import model.Course;
import model.Degree;
import model.Grade;
import model.Professor;
import model.Student;

public class MainService {
	
	private static ArrayList<Professor> allProfessors = new ArrayList<Professor>();
	private static ArrayList<Student> allStudents = new ArrayList<Student>();
	private static ArrayList<Course> allCourses = new ArrayList<Course>();
	private static ArrayList<Grade> allGrades = new ArrayList<Grade>();

	public static void main(String[] args) {
		Professor pr1 = new Professor();//John Big - default Professor
		Professor pr2 = new Professor("Karina", "Skirmante", Degree.mg);
		Professor pr3 = new Professor("Estere", "Vitola", Degree.mg);
		Professor pr4 = new Professor("Marcis", "Naktins", Degree.mg);
		
		allProfessors.addAll(Arrays.asList(pr1, pr2, pr3, pr4));
		
		//TO DO: take a look to ArrayList class in JAVA documentation
		for(int i = 0; i < allProfessors.size(); i++) {
			System.out.println(allProfessors.get(i));
		}
		
		System.out.println("-----------------------------------");
		
		for(Professor tempPr: allProfessors) {
			System.out.println(tempPr);
		}

		System.out.println("-----------------------------------");
		
		
		Student st1 = new Student(); //Lara Bernardes student
		Student st2 = new Student("Viktors", "Kokin", "123456-12345");
		Student st3 = new Student("Davyd", "Akimov", "123436-12245");
		
		allStudents.addAll(Arrays.asList(st1, st2, st3));
		
		for(Student tempPr: allStudents) {
			System.out.println(tempPr);
		}
		
		System.out.println("-----------------------------------");
		
		Course c1 = new Course();
		Course c2 = new Course("Data Structure", 2, pr3);
		Course c3 = new Course("Networking", 4, pr4);
		Course c4 = new Course("JAVA", 4, pr2);
		
		allCourses.addAll(Arrays.asList(c1, c2, c3));
		
		for(Course tempPr: allCourses) {
			System.out.println(tempPr);
		}
		
		
		Grade gr1 = new Grade();
		allGrades.add(gr1);
		Grade gr2 = new Grade(4, st3, c3);
		allGrades.add(gr2);
		Grade gr3 = new Grade(10, st3, c2);
		allGrades.add(gr3);
		Grade gr4 = new Grade(7, st2, c2);
		allGrades.add(gr4);
		Grade gr5 = new Grade(10, st2, c3);
		allGrades.add(gr5);
		Grade gr6 = new Grade(8, st2, c1);
		allGrades.add(gr6);
		Grade gr7 = new Grade(8, st2, c4);
		allGrades.add(gr7);
		Grade gr8 = new Grade(8, st1, c4);
		allGrades.add(gr8);
		Grade gr9 = new Grade(8, st1, c3);
		allGrades.add(gr9);
		
		
		
		System.out.println("-----------------------------------");
		
		
		for(Grade tempPr: allGrades) {
			System.out.println(tempPr);
		}
		
		System.out.println("-----------------------------------");
		
		try {
			System.out.println("AVG: " + st3.getName() + " " + st3.getSurname() + " -> " + calculateAVGForStudent(st3));
			System.out.println("AVG: " + st2.getName() + " " + st2.getSurname() + " -> " + calculateAVGForStudent(st2));
			System.out.println("-----------------------------------");
			
			System.out.println("WEIGHTED AVG: " + st3.getName() + " " + st3.getSurname() + " -> " + calculateWeightedAVGforStudent(st3));
			System.out.println("WEIGHTED AVG: " + st2.getName() + " " + st2.getSurname() + " -> " + calculateWeightedAVGforStudent(st2));
			System.out.println("-----------------------------------");
			
			System.out.println("COURSE AVG: " + c2.getTitle() + " -> " + courseAVG(c2));
			System.out.println("COURSE AVG: " + c3.getTitle() + " -> " + courseAVG(c3));
			System.out.println("COURSE AVG: " + c4.getTitle() + " -> " + courseAVG(c4));
			System.out.println("-----------------------------------");
			
			System.out.println("COURSES PER PROFESSOR:" + pr1.getName() + " " +  pr1.getSurname() + " -> " + coursesPerProfessor(pr1));
			System.out.println("COURSES PER PROFESSOR: " + pr2.getName() + " " + pr2.getSurname() + " -> " + coursesPerProfessor(pr2));
			System.out.println("COURSES PER PROFESSOR: " + pr3.getName() + " " + pr3.getSurname() + " -> " + coursesPerProfessor(pr3));
			System.out.println("COURSES PER PROFESSOR: " + pr4.getName() + " " + pr4.getSurname() + " -> " + coursesPerProfessor(pr4));
			System.out.println("-----------------------------------");
			
			for(Student tempSt: allStudents) {
				System.out.println(tempSt.getName() + " " + tempSt.getSurname() + " -> " + calculateAVGForStudent(tempSt));
			}
			System.out.println("-----------------------------------");
			
			sortStudents();
			
			for(Student tempSt: allStudents) {
				System.out.println(tempSt.getName() + " " + tempSt.getSurname() + " -> " + calculateAVGForStudent(tempSt));
			}
			
			System.out.println("-----------------------------------");
			System.out.println("Retrieving Viktors: ");
			Student temp = retrieveStudentByPersonCode("123456-12345");
			System.out.println("Retrieved student: " + temp);
			
			
			System.out.println("-----------------------------------");
			System.out.println("Creating Sara: ");
			createStudent("Sara", "Green", "234454-23445");
			for(Student tempSt: allStudents) {
				System.out.println(tempSt);
			}
			
			
			System.out.println("-----------------------------------");
			System.out.println("Deleting Davyd: ");
			deleteStudentByPersonCode("123436-12245");
			for(Student tempSt: allStudents) {
				System.out.println(tempSt);
			}
			
			System.out.println("-----------------------------------");
			System.out.println("Updating Viktors last name: ");
			updateStudentByPersonCode("Viktors", "Berzins", "123456-12345");
			for(Student tempSt: allStudents) {
				System.out.println(tempSt);
			}
			
			
			
			
		}
		catch (Exception e){
			System.out.println("e");
		}
		
		

	}
	
	public static float calculateAVGForStudent(Student inputStudent) throws Exception {
		if(inputStudent == null) throw new Exception("Problems with input");
		
		float sum = 0;
		int howMany = 0;
		
		for(Grade tempGr : allGrades) {
			if(tempGr.getStudent().equals(inputStudent)) {
				sum = sum + tempGr.getValue();
				howMany++;
			}
		}
		
		return sum/howMany;
		
	}
	
	public static float calculateWeightedAVGforStudent(Student inputStudent) throws Exception {
		if(inputStudent == null) throw new Exception("Problems with input");
		
		float sum = 0;
		int howMany = 0;
		
		for(Grade tempGr : allGrades) {
			if(tempGr.getStudent().equals(inputStudent)) {
				sum = sum + (tempGr.getValue() * tempGr.getCourse().getCreditPoints());
				howMany = howMany + tempGr.getCourse().getCreditPoints();
			}
		}
		
		return sum/howMany;
	}
	
	
	public static float courseAVG(Course course) throws Exception {
		if(course == null) throw new Exception("Problems with input");
		
		float sum = 0;
		int count = 0;
		
		for(Grade tempGr : allGrades) {
			if(tempGr.getCourse().equals(course)) {
				sum = sum + tempGr.getValue();
				count++;
			}
		}
		
		return sum/count;
		
	}
	
	public static int coursesPerProfessor(Professor professor) throws Exception {
		if(professor == null) throw new Exception("Problems with input");
		
		int count = 0;
		
		for(Course temCor: allCourses) {
			if(temCor.getProfessor().equals(professor)) {
				count++;
			}
		}
		
		return count;
	}
	
	public static void sortStudents() throws Exception {
		
		for(int i = 0; i < allStudents.size(); i++) {
			for(int j = 0; j < allStudents.size(); j++) {
				
				Student tempI = allStudents.get(i);
				Student tempJ = allStudents.get(j);
				
				if(calculateAVGForStudent(tempJ) < calculateAVGForStudent(tempI) ) {
					Student temp = allStudents.get(i);
					allStudents.set(i, allStudents.get(j));
					allStudents.set(j,  temp);
				}
			}
		}
		
	}
	
	// calculate how many professors have PhD as degree
	
	public static int phdCount() {
		
		int count = 0;
		
		for(Professor tempProf: allProfessors) {
			if(tempProf.getProfDegree().equals(Degree.phd)) {
				count++;
			}
			
		}
		
		return count;
		
	}
	
	// calculate how many grades are smaller than 4 in specific course
	
	// calculates how many CP professor need to lead
	
	
	// CRUD C - create, R - retrieve, U - update, D - delete
	
	public static Student retrieveStudentByPersonCode(String personCode) throws Exception {
		//1. do validation
		if(personCode == null) throw new Exception("Problems with input");
		//2. need to go through all students list and need to check if this student is in the list
		for(Student tempStud: allStudents) {
			if(tempStud.getPersonCode().equals(personCode)) {
				// 3. if it is - return student
				return tempStud;
			}
		}
		//4. throw exception if it is not
		 throw new Exception("Student is not found");
	}
	

	public static void createStudent(String name, String surname, String inputPersonCode) throws Exception {
		// 1. validation
		if(inputPersonCode == null || surname == null || name == null) throw new Exception("Problems with input");
		
		// 2. need to go through every student in the allStudents array list
		
		for(Student tempStud: allStudents) {
			// 3. need to check if there is already student with the same personCode
			if(tempStud.getPersonCode().equals(inputPersonCode)){
				// 4. if it is - throw an exception 
				throw new Exception("Student already exists!");
			}
			
		}
		
		// 5 - if it is not - create a new student 
		Student student = new Student(name, surname, inputPersonCode);
		
		// 6. store this student in allStudents array list
		allStudents.add(student);
		
	}
	
	
	public static void updateStudentByPersonCode(String name, String surname, String inputPersonCode) throws Exception {
		// 1. do validation
		if(inputPersonCode == null || surname == null || name == null) throw new Exception("Problems with input");
		
		// 2. search the student by its personCode
		for(Student tempStud: allStudents) {
			if(tempStud.getPersonCode().equals(inputPersonCode)) {
				// 3. update name and surname
				tempStud.setName(name);
				tempStud.setSurname(surname);
				return;
			}	
		}
		// 4. throws exception if person code does not exist
		throw new Exception("Person code does not exist!");
		
	}
	
	
	public static void deleteStudentByPersonCode(String inputPersonCode) throws Exception {
		// 1. do validation
		if(inputPersonCode == null) throw new Exception("Problems with input");
		
		// 2. search the student by its personCode
		for(Student tempStud: allStudents) {
			if(tempStud.getPersonCode().equals(inputPersonCode)) {
				// 3. remove student
				allStudents.remove(tempStud);
				return;
			}	
		}
		// 4. throws exception if person code does not exist
		throw new Exception("Person code does not exist!");
		
	}
	
	
	
	
	
	
	

}