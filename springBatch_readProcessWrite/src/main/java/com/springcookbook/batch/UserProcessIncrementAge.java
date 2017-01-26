package com.springcookbook.batch;

import com.springcookbook.domain.User;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by davidronaldson on 26/01/2017.
 */
public class UserProcessIncrementAge implements ItemProcessor<User , User> {
    public User process(User user) throws Exception {
        int age = user.getAge();
        age++;
        user.setAge(age);
        return user;
    }
}
