package com.silentsunshine.blueprintsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.silentsunshine.blueprintsystem.entity.Permission;
import com.silentsunshine.blueprintsystem.mapper.PermissionMapper;
import com.silentsunshine.blueprintsystem.service.IPermissionService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-26
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {
    @Override
    public List<Integer> getTaskIds(String userId) {
        List<Permission> permissions = baseMapper.getStatisticsByUserId(userId);
        List<Integer> taskIds = permissions.stream()
                .map(item -> item.getTaskId())
                .collect(Collectors.toList());
        // 查询permission表中type==2 and includes 包含 userId的记录
        return taskIds;
    }
}
