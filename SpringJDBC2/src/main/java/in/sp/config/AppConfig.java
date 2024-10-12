package in.sp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("in.sp")
public class AppConfig
{
    @Bean
    public DriverManagerDataSource dataSource()
    {
        return new DriverManagerDataSource("jdbc:mysql://localhost:3306/spring_jdbc_db","root","admin560");
    }

    @Bean
    public JdbcTemplate jdbcTemplate()
    {
        return new JdbcTemplate(dataSource());
    }
}
