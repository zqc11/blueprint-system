package com.silentsunshine.blueprintsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.silentsunshine.blueprintsystem.entity.User;
import com.silentsunshine.blueprintsystem.vo.Result;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-23
 */
public interface IUserService extends IService<User> {
    Result getUser(String account, String password);
}
