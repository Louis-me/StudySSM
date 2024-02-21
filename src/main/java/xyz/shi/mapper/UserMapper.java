package xyz.shi.mapper;

import com.github.pagehelper.Page;
import xyz.shi.pojo.User;

public interface UserMapper {
    User findUser(int id);
    void save(User user);
    void saveTx(User user);
    Page<User> findAll();
}
