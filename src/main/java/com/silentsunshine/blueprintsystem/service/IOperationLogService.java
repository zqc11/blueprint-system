package com.silentsunshine.blueprintsystem.service;

import com.silentsunshine.blueprintsystem.entity.OperationLog;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-26
 */
public interface IOperationLogService extends IService<OperationLog> {
    List<OperationLog> listByTaskId(Integer taskId);
}
