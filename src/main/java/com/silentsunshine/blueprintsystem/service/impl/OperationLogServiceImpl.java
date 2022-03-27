package com.silentsunshine.blueprintsystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.silentsunshine.blueprintsystem.entity.OperationLog;
import com.silentsunshine.blueprintsystem.mapper.OperationLogMapper;
import com.silentsunshine.blueprintsystem.service.IOperationLogService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-26
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogMapper, OperationLog> implements IOperationLogService {
    @Override
    public List<OperationLog> listByTaskId(Integer taskId) {
        return this.listByMap(Collections.singletonMap("task_id", taskId));
    }
}
