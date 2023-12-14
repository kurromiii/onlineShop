import com.mftplus.onlineshop.model.entity.User;
import com.mftplus.onlineshop.model.entity.enums.UserRole;
import com.mftplus.onlineshop.model.service.UserService;

public class Test {
    public static void main(String[] args) throws Exception {
        //save
//        User user =
//                User
//                        .builder()
//                        .name("reza")
//                        .family("alipour")
//                        .username("reza")
//                        .password("123")
//                        .userRole(UserRole.customer)
//                        .build();
//        System.out.println(UserService.getUserService().save(user));

        //edit
//        User user =
//                User
//                        .builder()
//                        .name("Ali")
//                        .family("Alipour")
//                        .username("ali")
//                        .password("123")
//                        .userRole(UserRole.customer)
//                        .build();
//        System.out.println(UserService.getUserService().edit(user));

        //findById
//        User user =
//                User
//                        .builder()
//                        .name("ali")
//                        .family("alipour")
//                        .username("ali")
//                        .password("123")
//                        .userRole(UserRole.customer)
//                        .build();
//        System.out.println(UserService.getUserService().findById("ali"));

        //findByUsername
//        System.out.println(UserService.getUserService().findByUsername("ali"));

        //findByUserNameAndPassword
//        System.out.println(UserService.getUserService().findByUsernameAndPassword("reza","123"));
//        System.out.println(UserService.getUserService().findByUsernameAndPassword("ali","1"));
//        System.out.println(UserService.getUserService().findByUsernameAndPassword("reza","123"));
        User user = new User();
        System.out.println(UserService.getUserService().findByUsernameAndPassword("melody","123"));
    }
}
