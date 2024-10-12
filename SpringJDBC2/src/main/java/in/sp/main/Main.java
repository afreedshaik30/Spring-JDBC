package in.sp.main;

import in.sp.config.AppConfig;
import in.sp.dao.StudentDao;
import in.sp.entity.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main
{
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentDao dao = context.getBean(StudentDao.class);

        //insertion
//        Student s1=new Student(401,"nafeez",5.67f);
//        dao.insert(s1);

        //delete
        dao.delete(502);

        //selectByRno
         Student s3=dao.selectByRno(401);
         System.out.println(s3.getSno()+ "--" +s3.getSname()+ "--" + s3.getMarks());

        //updation
          Student s2=dao.selectByRno(401);
          s2.setSname("Abdul");
          s2.setMarks(12.3333f);
          dao.update(s2);

        //selectAll
        List<Student> studentList=dao.selectAll();
        for(Student s:studentList)
        {
            System.out.println("sno: "+s.getSno());
            System.out.println("sname :"+s.getSname());
            System.out.println("marks :"+s.getMarks());
            System.out.println("<---------------------------------->");
        }
    }
}
