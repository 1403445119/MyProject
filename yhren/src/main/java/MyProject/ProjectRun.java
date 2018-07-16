package MyProject;

        import org.mybatis.spring.annotation.MapperScan;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.context.annotation.ComponentScan;
        import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableAutoConfiguration
@SpringBootApplication
@EnableTransactionManagement
@MapperScan("Dao")
@ComponentScan("Controller")
@ComponentScan("Service")
public class ProjectRun {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ProjectRun.class, args);
    }
}
