package xyz.shi.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class User {
    private int id;
    @NotNull(message = "用户名不能为空")
    private String name;
    @Length(min = 5, max = 100, message = "密码长度只能在5-100之间")
    private String password;
}