package tn.rnu.eniso.DAO;
import java.util.List;
import javax.sql.DataSource;
import tn.rnu.eniso.model.*;
public interface IStudentDAO {

	 //  public void setDataSource(DataSource ds);
	   public void create(Student s);
	   public Student getStudent(Integer id);
	   public List<Student> listStudents();
	   public void delete(Integer id);
	   public void update(Integer id, Student s);
}
