package com.dk.mallchat.common;

import com.dk.mallchat.common.user.dao.UserDao;
import com.dk.mallchat.common.user.domain.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DaoTest {
    @Autowired
    UserDao userDao;

    @Test
    public void test(){
        User byId = userDao.getById("1");
        User u1 = new User();
        u1.setName("¶­¿Æ");
        u1.setOpenId("123");
        boolean save = userDao.save(u1);
        System.out.println(save);
    }
}
