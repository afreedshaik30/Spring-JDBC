package in.sp.dao;

import in.sp.entity.Student;

import java.util.List;

public interface StudentDao
{
    void insert(Student student);
    void update(Student student);
    void delete(int sno);
    List<Student> selectAll();
    Student selectByRno(int sno);
}
