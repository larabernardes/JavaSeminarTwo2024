package service;

import java.util.ArrayList;

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
		allProfessors.add(pr1);
		Professor pr2 = new Professor("Karina", "Skirmante", Degree.mg);
		allProfessors.add(pr2);
		Professor pr3 = new Professor("Estere", "Vitola", Degree.mg);
		allProfessors.add(pr3);
		Professor pr4 = new Professor("Marcis", "Naktins", Degree.mg);
		allProfessors.add(pr4);
		
		//TO DO: take a look to ArrayList class in JAVA documentation
		for(int i = 0; i < allProfessors.size(); i++) {
			System.out.println(allProfessors.get(i));
		}
		
		System.out.println("-----------------------------------");
		
		for(Professor tempPr: allProfessors) {
			System.out.println(tempPr);
		}
		
		System.out.println("-----------------------------------");
		
		
		Student st1 = new Student();//Lara Bernardes student
		allStudents.add(st1);
		Student st2 = new Student("Viktors", "Kokin");
		allStudents.add(st2);
		Student st3 = new Student("Davyd", "Akimov");
		allStudents.add(st3);
		
		for(Student tempPr: allStudents) {
			System.out.println(tempPr);
		}
		
		System.out.println("-----------------------------------");
		
		Course c1 = new Course();
		allCourses.add(c1);
		Course c2 = new Course("Data Structure", 2, pr3);
		allCourses.add(c2);
		Course c3 = new Course("Networking", 4, pr4);
		allCourses.add(c3);
		
		for(Course tempPr: allCourses) {
			System.out.println(tempPr);
		}
		
		System.out.println("-----------------------------------");
		
		
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
		
		System.out.println("-----------------------------------");
		
		
		for(Grade tempPr: allGrades) {
			System.out.println(tempPr);
		}
		
		try {
			System.out.println(st3.getName() + " " + st3.getSurname() + " -> " + calculateAVGForStudent(st3));
			System.out.println(st2.getName() + " " + st2.getSurname() + " -> " + calculateAVGForStudent(st2));
			
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

}