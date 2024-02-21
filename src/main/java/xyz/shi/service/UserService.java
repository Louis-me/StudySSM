package xyz.shi.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import xyz.shi.mapper.UserMapper;
import xyz.shi.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    public void test(){
        System.out.println("test....");
    }
    public User getUser(int id){
        return userMapper.findUser(id);
    }

    public Page<User> findAll(Integer PageNum, Integer PageSize) {
        //在查询之前，设置分页条件 显示第一页，展示3条数据
        Page<Object> page = PageHelper.startPage(PageNum, PageSize);
        return userMapper.findAll();
    }
    @Transactional
    public void saveTx(User user) {
        userMapper.save(user);
        int i = 10 / 0; //模拟发生异常
        // 加上事务标识后，只有出现异常才不会造成新增数据成功
    }
    public void save(User user) {
         userMapper.save(user);
    }
}
