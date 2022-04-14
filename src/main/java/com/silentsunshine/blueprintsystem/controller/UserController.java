package com.silentsunshine.blueprintsystem.controller;

import com.silentsunshine.blueprintsystem.entity.User;
import com.silentsunshine.blueprintsystem.service.IUserService;
import com.silentsunshine.blueprintsystem.vo.Result;
import com.silentsunshine.blueprintsystem.vo.UserVO;
import com.silentsunshine.blueprintsystem.vo.params.LoginParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-23
 */
@RestController
public class UserController {
    @Autowired
    IUserService userService;

    /**
     * 用户登录
     *
     * @param login 登录参数
     * @return Result
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginParams login) {
        System.out.println("account:" + login.getAccount() + " password: " + login.getPassword());
        if (login.getAccount().isEmpty() || login.getPassword().isEmpty()) {
            return Result.failure(401, "帐户或密码不能为空");
        }
        return userService.getUser(login.getAccount(), login.getPassword());
    }

    /**
     * 用户注册
     *
     * @return Result
     */
    @PostMapping("/register")
    public Result register() {
        return Result.success(null);
    }

    /**
     * 动态路由
     *
     * @return Result
     */
    @GetMapping("/getAsyncRoutes")
    public Result getAsyncRoutes() {
        return Result.success(new ArrayList<>());
    }

    @GetMapping("/friends/{id}")
    public Result getFriends(@PathVariable("id") String id) {
        List<UserVO> friends = userService.list().stream()
                .map(UserVO::new)
                .collect(Collectors.toList());
        return Result.success(friends);
    }

    @GetMapping("/user/{id}")
    public Result getUser(@PathVariable("id") String id) {
        User user = userService.getUserById(id);
        return Result.success(new UserVO(user));
    }
}
