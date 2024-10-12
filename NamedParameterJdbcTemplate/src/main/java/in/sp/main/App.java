package in.sp.main;

import in.sp.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class App
{
    public static void main(String[] args)
    {
         var context=new AnnotationConfigApplicationContext(AppConfig.class);
         NamedParameterJdbcTemplate namedParameterJdbcTemplate=context.getBean(NamedParameterJdbcTemplate.class);

        Map<String, Object> mapElements=new HashMap<>();
        mapElements.put("key_sno",502);
        mapElements.put("key_sname","BABU");
        mapElements.put("key_marks",8.25);

        String insertionQuery="INSERT INTO student VAlUES(:key_sno,:key_sname,:key_marks)";
        int rowsAffected = namedParameterJdbcTemplate.update(insertionQuery,mapElements);
        if(rowsAffected>0)
            System.out.println("insertion success");
        else
            System.out.println("FAILED");
    }
}
