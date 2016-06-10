package tn.rnu.eniso.DAO.jdbc;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import tn.rnu.eniso.DAO.IStudentDAO;
import tn.rnu.eniso.DAO.StudentMapper;
import tn.rnu.eniso.model.*;

public class StudentJDBCTemplate implements IStudentDAO {
	private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }

	   public void create(Student s) {
	      String SQL = "insert into Student (name, age) values (?, ?)";
	      
	      jdbcTemplateObject.update( SQL, s.getName(), s.getAge());
	      System.out.println("Created Record Name = " + s.getName() + " Age = " + s.getAge());
	      return;
	   }

	   public Student getStudent(Integer id) {
	      String SQL = "select * from Student where id = ?";
	      Student student = jdbcTemplateObject.queryForObject(SQL, 
	                        new Object[]{id}, new StudentMapper());
	      return student;
	   }

	   public List<Student> listStudents() {
	      String SQL = "select * from Student";
	      List <Student> students = jdbcTemplateObject.query(SQL, 
	                                new StudentMapper());
	      return students;
	   }

	   public void delete(Integer id){
	      String SQL = "delete from Student where id = ?";
	      jdbcTemplateObject.update(SQL, id);
	      System.out.println("Deleted Record with ID = " + id );
	      return;
	   }

	   public void update(Integer id, Student s){
	      String SQL = "update Student set age = ? where id = ?";
	      jdbcTemplateObject.update(SQL, s.getAge(), id);
	      System.out.println("Updated Record with ID = " + id );
	      return;
	   }

}
