import controllers.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        ConnectCalendar c = new ConnectCalendar();
        c.showCalendar();

        UserController user = new UserController();
        String message = user.addNewUser("")
    }
}