package hiber;

import hiber.config.AppConfig;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("Elvina", "Ismak", "elvina2gmail.com",
              new Car(2023, "NISSAN"));
      User user2 = new User("Elvin", "Ismakov", "elvin3gmail.com",
              new Car(2022, "BMW"));
      User user3 = new User("Adelya", "Ismakova", "adelyagmail.com",
              new Car(2021, "OPEL-ASTRA"));
      User user4 = new User("Azamat", "Ismakov", "azamat33gmail.com",
              new Car(2024, "TOYOTA"));

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCar());
         System.out.println();
      }

      System.out.println(userService.findUserByCar("BMW", 2022));

      context.close();
   }
}
