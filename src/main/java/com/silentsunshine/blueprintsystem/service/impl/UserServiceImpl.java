package com.silentsunshine.blueprintsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.silentsunshine.blueprintsystem.entity.User;
import com.silentsunshine.blueprintsystem.mapper.UserMapper;
import com.silentsunshine.blueprintsystem.service.IUserService;
import com.silentsunshine.blueprintsystem.vo.Result;
import com.silentsunshine.blueprintsystem.vo.UserVO;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public Result getUser(String account, String password) {
        Result result;
        User user = baseMapper.selectOne(new QueryWrapper<User>().eq("account", account));
        if (user == null || ! user.getPassword().equals(password)) {
            result = Result.failure(400, "帐户不存在或密码错误");
        } else {
            UserVO userVO = new UserVO(user);
            result = Result.success(userVO);
        }
        return result;
    }
}
