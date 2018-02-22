package DoublyLinked;

import java.io.IOException;
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class Lab34ast {
	public static void main(String args[]) throws IOException {
		DoubleList studentList = new DoubleList();
		studentList.getList();
		studentList.displayAll();
		//studentList.pause();
		studentList.displayHonorRoll();
		//studentList.pause();
		studentList.displayAcademicProbation();
		//studentList.pause();
		
		int studentID = getID();
		Student2Node nodeRef = studentList.search(studentID);

		if (nodeRef == null)
		    System.out.println("There is no student with an ID# of "+studentID+".\n");
		else {
			studentList.displayStudent(nodeRef);
			studentList.pause();
			studentList.delete(nodeRef);
			studentList.displayAll();
		}
	}
	
	private static int getID() {
		System.out.print("\nEnter the 6-digit ID of the student.  { 100000 - 999999 }  -->  ");
		return new Scanner(System.in).nextInt();
	}
}

class Student2Node {
	private String 		 name;
	private int 		 id;
	private int 		 age;
	private double 		 gpa;
	private Student2Node forward;	
	private Student2Node back;	
	
	Student2Node (String n, int ID, int a, double g, Student2Node f, Student2Node b) {
		name    = n;
		id      = ID;
		age     = a;
		gpa     = g;
		forward = f;
		back    = b;
	}

	String getName ()					{ return name;		}
	int getID ()							{ return id;		}
	int getAge ()						{ return age;		}
	double getGPA ()						{ return gpa;		}
	Student2Node getForward ()			{ return forward;	}
	Student2Node getBack ()				{ return back;		}

	void setName (String n)				{ name    = n;		}
	void setID (int ID)			 		{ id      = ID;		}
	void setAge (int a)					{ age     = a;		}
	void setGPA (double g)				{ gpa     = g;		}
	void setForward (Student2Node f)		{ forward = f; 		}
	void setBack (Student2Node b)		{ back    = b;		}

	public String toString() {
		return String.format("%-16d%-23s%-12d %2.3f", id, name, age, gpa);
	}
}

class DoubleList {
	Student2Node front, back;
	DecimalFormat output;
   
	DoubleList() {
		front = back = null;       
		output  = new DecimalFormat("0.000");		   
	}

	void getList() throws IOException {
		FileReader inFile = new FileReader("students2.dat");	
		BufferedReader inStream = new BufferedReader(inFile);	     
		String s1,s2,s3,s4;
		int age, id;
		double gpa;						
		while( ((s1 = inStream.readLine()) != null) && 
			   ((s2 = inStream.readLine()) != null) && 
			   ((s3 = inStream.readLine()) != null) &&
			   ((s4 = inStream.readLine()) != null) )	
		{
			String name = s1;
			id = Integer.parseInt(s2);
			age = Integer.parseInt(s3);
			gpa = Double.parseDouble(s4);

			Student2Node newStudent = new Student2Node(name,id,age,gpa,null,null); 
			insert(newStudent);
		}   
		inStream.close(); 
					
	}
      
    private void insert(Student2Node newStudent) {
		Student2Node t1, t2 = null;
    	if(front == null) {
    		front = back = newStudent;
		} else if(newStudent.getGPA() < front.getGPA()) {
    		newStudent.setForward(front);
    		front.setBack(newStudent);
    		front = newStudent;
		} else {
			t1 = front;
			while(t1 != null && newStudent.getGPA() > t1.getGPA()) {
				t2 = t1;
				t1 = t1.getForward();
			}
			t2.setForward(newStudent);
			newStudent.setForward(t1);
			newStudent.setBack(t2);
			if(t1 != null) t1.setBack(newStudent);
			if(newStudent.getForward() == null) back = newStudent;
		}
	}
        	
	void displayAll() {
		System.out.println("\nDISPLAYING ALL STUDENTS");
		System.out.println("\nStudent ID#     Student Name            Age         GPA");
		System.out.println("============================================================");
		Student2Node t1 = back;
		while(t1 != null) {
			System.out.println(t1);
			t1 = t1.getBack();
		}
	}	
	
	void displayHonorRoll() {
		System.out.println("\nDISPLAYING HONOR ROLL STUDENTS");
		System.out.println("\nStudent ID#     Student Name            Age         GPA");
		System.out.println("============================================================");
		Student2Node t1 = back;
		while(t1!= null && t1.getGPA() >= 3.5) {
			System.out.printf("%-16d%-23s%-12d %2.3f\n", t1.getID(), t1.getName(), t1.getAge(), t1.getGPA());
			t1 = t1.getBack();
		}

	}	   
		
	void displayAcademicProbation() {
		System.out.println("\nDISPLAYING ACADEMIC PROBATION STUDENTS");
		System.out.println("\nStudent ID#     Student Name            Age         GPA");
		System.out.println("============================================================");
		Student2Node t1 = front;
		while(t1 != null && t1.getGPA() < 2.000) {
			System.out.printf("%-16d%-23s%-12d %2.3f\n", t1.getID(), t1.getName(), t1.getAge(), t1.getGPA());
			t1 = t1.getForward();
		}

	}	
	
	void pause() {
		Scanner input = new Scanner(System.in);	 
		String dummy;
		System.out.println("\nPress <Enter> to continue.");						
		dummy = input.nextLine();								
	}

	void displayStudent(Student2Node p) {
		System.out.println("\nStudent Record for ID# " + p.getID() + "\n");
		System.out.printf("%-6s%s\n%-6s%d\n%-6s%1.3f\n", "Name:", p.getName(), "Age:", p.getAge(), "GPA:",p.getGPA());
	}   

	Student2Node search(int studentID) {
		if(front == null) return null;
		else {
			Student2Node p = front;
			while(p.getForward()!=null && p.getID() != studentID) {
				p = p.getForward();
			}
			return p;
		}

	}
	
	void delete(Student2Node p) {
		if(front==null) {
			return;
		} else {
			if(front == p) {
				if(front.getForward() != null) front.getForward().setBack(null);
				front.setForward(null);
			} else {
				Student2Node t1 = front, t2 = null;
				boolean exists = false;
				while(t1!=null && !exists) {
					exists = p == t1;
					if(!exists) {
						t2 = t1;
						t1 = t1.getForward();
					}
				}
				t2.setForward(t1.getForward());
				if(t1.getForward().getForward() != null) t1.getForward().getForward().setBack(t2);
			}
		}
	}	
}
