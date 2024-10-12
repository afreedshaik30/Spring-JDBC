package in.sp.dao;

import in.sp.entity.Student;
import in.sp.rowMapper.StudentRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class StudentDaoImpl implements StudentDao
{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert(Student student)
    {
        String query="INSERT INTO student VALUES(?,?,?)";
        jdbcTemplate.update(query,student.getSno(),student.getSname(),student.getMarks());
    }

    @Override
    public void update(Student student)
    {
       String query="UPDATE student SET sname=?, marks=? WHERE sno=?";
       jdbcTemplate.update(query,student.getSname(),student.getMarks(),student.getSno());
    }

    @Override
    public void delete(int sno)
    {
       String query="DELETE FROM student WHERE sno=?";
       jdbcTemplate.update(query,sno);
    }

    @Override
    public List<Student> selectAll()
    {
        String query="SELECT * FROM student";
        List<Student> studentList=jdbcTemplate.query(query,new StudentRowMapper());
        return studentList;
    }

    @Override
    public Student selectByRno(int sno)
    {
        StudentRowMapper rowMapper=new StudentRowMapper();
        String query="SELECT * FROM student WHERE sno=?";
        return jdbcTemplate.queryForObject(query,rowMapper,sno);
    }
}
