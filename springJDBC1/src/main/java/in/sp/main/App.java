package in.sp.main;

import in.sp.bean.Student;
import in.sp.config.AppConfig;
import in.sp.mapper.StudentRowMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

//     1.Insertion :-
//        int sno=501;
//        String sname="Asha";
//        float marks=9.87f;

          String insertQuery = "INSERT INTO student VALUES(?,?,?)";
//        int rowsAffected=jdbcTemplate.update(insertQuery, sno, sname, marks);
//        if(rowsAffected> 0)
//            System.out.println("Inserted");
//        else
//            System.out.println("not inserted");

//     2.Updation :-
//        String name="Shaik Afreed";
//        int id=560;
          String updationQuery = "UPDATE student SET sname=? WHERE sno=?"; //database column names
//        int rowsAffected=jdbcTemplate.update(updationQuery,name,id);//variables
//        if(rowsAffected>0)
//            System.out.println("Updated");
//        else
//            System.out.println("NOT Updated");

//     3.deletion :-
//        int id=502;
          String deletionQuery = "DELETE FROM student WHERE sno=?";
//        int rowsAffected= jdbcTemplate.update(deletionQuery,id);
//        if(rowsAffected> 0)
//            System.out.println("Inserted");
//        else
//            System.out.println("not inserted");

//      4.select
/*
     Student.java(fields , setters , getters) ,
     StudentRowMapper.java ( implements RowMapper<Student>,
                             @Override mapRow(),
                             create Student object to set fields with resultSet getters("columnLabel's")
                             )
 */

          String selectQuery = "SELECT * FROM student";
          //Passing (selectQuery, new Student-RowMapper object) in query() returns a List of Student Objects

//        List<Student> listOfStudent = jdbcTemplate.query(selectQuery, new StudentRowMapper());
//        for (Student s : listOfStudent)
//        {
//            System.out.println("roll no : "+s.getRno());
//            System.out.println("name : "+s.getName());
//            System.out.println("marks : "+s.getMarks());
//            System.out.println(" ============================================= ");
//        }

//5. Select By given ID
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter your rno :-");
        int rollno = sc.nextInt();

        String selectByID = "SELECT * FROM student WHERE sno=?";
        //passing (query, custom-RowMapper Object, id ) in queryForObject returns a Single Student Object
        Student studentObject = jdbcTemplate.queryForObject(selectByID, new StudentRowMapper(), rollno);
            System.out.println("roll no : " + studentObject.getRno());
            System.out.println("name : " + studentObject.getName());
            System.out.println("marks : " + studentObject.getMarks());
    }
}