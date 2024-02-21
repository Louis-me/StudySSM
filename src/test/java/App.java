import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import xyz.shi.pojo.User;
import xyz.shi.service.UserService;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean(UserService.class);
        userService.test();

        User user = userService.getUser(4);
        System.out.println(user);

        List<User> userList = userService.findAll(1,10);
        // 设置分页导航数量5
//        PageInfo<User> pageInfo = new PageInfo<>(userList, 5);
        for (User user1:userList) {
            System.out.println("------每个用户的信息-------");
            System.out.println(user1.getName());
            System.out.println(user1.getPassword());
        }
    }
}
