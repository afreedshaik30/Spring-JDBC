package in.sp.rowMapper;

import in.sp.entity.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student>
{

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException
    {
        Student stu=new Student();
        stu.setSno(rs.getInt("sno"));
        stu.setSname(rs.getString("sname"));
        stu.setMarks(rs.getFloat("marks"));
        return stu;
    }
}
