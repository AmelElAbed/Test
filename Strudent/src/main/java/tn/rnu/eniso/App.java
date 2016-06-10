package tn.rnu.eniso;
import tn.rnu.eniso.model.*;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import tn.rnu.eniso.DAO.*;
import tn.rnu.eniso.DAO.jdbc.StudentJDBCTemplate;


public class App {

	 public static void main(String arg[])
	  {
		 ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
			/*A obj = (A) context.getBean("idA");
			obj.method1();*/
		 //changement
			Student s1 = (Student) context.getBean("s");
		      StudentJDBCTemplate studentJDBCTemplate = 
		    	      (StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
		    	      System.out.println("------Records Creation--------" );
		    	      Student s = new Student ("Ameni", 25);
		    	     studentJDBCTemplate.create(s);
		    	    /*  studentJDBCTemplate.create("Nouha", 22);
		    	      studentJDBCTemplate.create("safa", 15);*/

		    	    
		    	    // Student s2 = new Student ("Ameni", 30);
		    	    // System.out.println("----Updating Record with ID = 2 -----" );
		    	   //   studentJDBCTemplate.update(17, s2);
		    	      System.out.println("------Listing Multiple Records--------" );
		    	      List<Student> students = studentJDBCTemplate.listStudents();
		    	      for (Student record : students) {
		    	         System.out.print("ID : " + record.getId() );
		    	         System.out.print(", Name : " + record.getName() );
		    	         System.out.println(", Age : " + record.getAge());
		    	      }

		    	  /*    System.out.println("----Listing Record with ID = 2 -----" );
		    	      Student student = studentJDBCTemplate.getStudent(2);
		    	      System.out.print("ID : " + student.getId() );
		    	      System.out.print(", Name : " + student.getName() );
		    	      System.out.println(", Age : " + student.getAge()); */
			
			

		  /*  UserManager userManager = (UserManager) context.getBean("userManagerImpl");

		    List<User> list = userManager.findAllUsers();
		    System.out.println("User count: " + list.size());

		    User user = new User();
		    user.setUsername("johndoe");
		    user.setName("John Doe");
		    userManager.insertUser(user);
		    System.out.println("User inserted!");

		    list = userManager.findAllUsers();
		    System.out.println("User count: " + list.size());*/
		    	      System.out.println("Test1" );
		    	   }
	  }

