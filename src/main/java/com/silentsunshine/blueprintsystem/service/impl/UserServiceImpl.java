package com.silentsunshine.blueprintsystem.service.impl;

import com.silentsunshine.blueprintsystem.entity.User;
import com.silentsunshine.blueprintsystem.mapper.UserMapper;
import com.silentsunshine.blueprintsystem.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
