package com.silentsunshine.blueprintsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.silentsunshine.blueprintsystem.entity.Permission;
import com.silentsunshine.blueprintsystem.mapper.PermissionMapper;
import com.silentsunshine.blueprintsystem.service.IPermissionService;
import com.silentsunshine.blueprintsystem.vo.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;
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
        // 查询permission表中type==2 and includes 包含 userId的记录
        return permissions.stream()
                .map(Permission::getTaskId)
                .collect(Collectors.toList());
    }

    @Override
    public int insertMaintain(List<String> maintain, int taskId) {
        StringBuilder stringBuilder = new StringBuilder(",");
        for (String userId : maintain) {
            stringBuilder.append(userId).append(",");
        }
        Permission permission = new Permission(1, stringBuilder.toString(), taskId);
        return baseMapper.insert(permission);
    }

    @Override
    public int insertStatistics(List<String> statistics, int taskId) {
        StringBuilder stringBuilder = new StringBuilder(",");
        for (String userId : statistics) {
            stringBuilder.append(userId).append(",");
        }
        Permission permission = new Permission(2, stringBuilder.toString(), taskId);
        return baseMapper.insert(permission);
    }
}
