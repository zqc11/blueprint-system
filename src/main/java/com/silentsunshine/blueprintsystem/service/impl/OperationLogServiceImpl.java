package com.silentsunshine.blueprintsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.silentsunshine.blueprintsystem.entity.OperationLog;
import com.silentsunshine.blueprintsystem.mapper.OperationLogMapper;
import com.silentsunshine.blueprintsystem.service.IOperationLogService;
import com.silentsunshine.blueprintsystem.vo.OperatonLogVO;
import org.springframework.stereotype.Service;

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
    public List<OperatonLogVO> listAllByTaskIdAndNodeId(int taskId) {
        return baseMapper.listAllByTaskIdAndNodeId(taskId);
    }

    @Override
    public int addOperationLog(OperationLog operationLog) {
        return baseMapper.insert(operationLog);
    }
}
