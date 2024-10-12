package in.sp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig
{
    @Bean
     public DriverManagerDataSource myDataSource()
     {
         DriverManagerDataSource dataSource=new DriverManagerDataSource();
         dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
         dataSource.setUrl("jdbc:mysql://localhost:3306/spring_jdbc_db");
         dataSource.setUsername("root");
         dataSource.setPassword("admin560");
         return dataSource;
     }

     @Bean
     public NamedParameterJdbcTemplate namedParameterJdbcTemplate()
     {
         return new NamedParameterJdbcTemplate(myDataSource());
     }
}
