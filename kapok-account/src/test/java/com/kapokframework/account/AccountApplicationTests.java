package com.kapokframework.account;

import com.kapokframework.account.model.User;
import com.kapokframework.account.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class AccountApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void testCreate() {
        User user = User.builder()
                .username("liuba")
                .password("123456")
                .email("liuba@abc.com")
                .status("NORMAL")
                .build();
        User newUser = this.userService.create(user);
        Assert.assertEquals(user, newUser);
    }

    @Test
    public void testRetrieve() {
        Long id = 1L;
        User user = this.userService.retrieve(id);
        Assert.assertEquals(id, user.getId());
    }

    @Test
    public void testUpdate() throws Exception {
        Long id = 2L;
        Map<String, Object> values = new HashMap<>();
        values.put("email", "lisi@qq.com");
        User user = this.userService.update(id, values);
        log.info("User : {}", user);
        Assert.assertEquals("lisi@qq.com", user.getEmail());
    }

    @Test
    public void testDelete() {
        Long id = 5L;
        this.userService.delete(id);
        User user = this.userService.retrieve(id);
        Assert.assertNull(user);
    }

    @Test
    public void testRecycle() {
        Long id = 4L;
        this.userService.recycle(id);
        User user = this.userService.retrieve(id);
        Assert.assertEquals("DELETE", user.getStatus());
    }

    @Test
    public void testSearch() {
        Assert.assertNotNull(userService.search(null));
    }

}
