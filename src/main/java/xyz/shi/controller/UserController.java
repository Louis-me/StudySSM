package xyz.shi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import xyz.shi.handler.BusinessException;
import xyz.shi.handler.Result;
import xyz.shi.pojo.User;
import xyz.shi.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("getUser/{id}")
    public Result findUser(@PathVariable int id){
        System.out.println("getUser方法调用...");
        if (id == 2){
            throw new BusinessException(-999,"对不起，参数不能为2");
        }
        if (id == 3){
            throw new IndexOutOfBoundsException();
        }
        if (id == 4){
            int i = 10/0;
        }
        User user = userService.getUser(id);
        return new Result(true,200,"success",user);
    }
    @GetMapping("saveTx")
    public void saveTx(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userService.saveTx(user);
    }
    @PostMapping("save")
    public Result save( @Valid User user, BindingResult bindingResult) {
        System.out.println(user);
        if (bindingResult.hasErrors()) {
            //获取校验有错误的字段
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println(fieldError.getField());
                System.out.println(fieldError.getDefaultMessage());
                System.out.println("------------------------------");
                return new Result(true,-1,fieldError.getDefaultMessage(),null);

            }
        }
        userService.save(user);
        return new Result(true,200,"success",user);
    }
    @GetMapping("findAll")
    public List<User> findAll(Integer PageNum, Integer PageSize) {
        List<User> userList = userService.findAll(PageNum,PageSize);
        return userList;

    }
}
