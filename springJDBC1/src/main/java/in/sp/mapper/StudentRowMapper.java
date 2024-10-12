package in.sp.mapper;

import in.sp.bean.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper  implements RowMapper<Student>
{
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Student student=new Student();
        student.setRno(rs.getInt("sno"));
        student.setName(rs.getString("sname"));
        student.setMarks(rs.getFloat("marks"));
        return student;
    }
}
