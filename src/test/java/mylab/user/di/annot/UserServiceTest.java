package mylab.user.di.annot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testUserService() {

        // UserService 주입 확인
        assertNotNull(userService);

        // UserRepository 주입 확인
        assertNotNull(userService.getUserRepository());

        // DB 종류 확인
        assertEquals("MySQL", userService.getUserRepository().getDbType());

        // SecurityService 주입 확인
        assertNotNull(userService.getSecurityService());
    }

    @Test
    public void testRegisterUser() {

        // 비밀번호가 전달된 경우
        assertTrue(userService.registerUser("usersuccess", "성공", "password123"));

        // 비밀번호가 전달되지 않은 경우
        assertFalse(userService.registerUser("userfailure", "실패", ""));
    }
}