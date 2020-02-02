package com.wc.project.fruitshop.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author 王超
 * @Description TODO
 * @create 2020/1/22 20:19
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private Byte gender;
    private Date birthday;
    private String mobile;
    private String nickname;
    private String avatar;
}
