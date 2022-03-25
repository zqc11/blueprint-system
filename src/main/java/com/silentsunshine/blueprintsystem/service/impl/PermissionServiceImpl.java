package com.silentsunshine.blueprintsystem.service.impl;

import com.silentsunshine.blueprintsystem.entity.Permission;
import com.silentsunshine.blueprintsystem.mapper.PermissionMapper;
import com.silentsunshine.blueprintsystem.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-25
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
