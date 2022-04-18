package com.silentsunshine.blueprintsystem.service;

import com.silentsunshine.blueprintsystem.entity.OperationLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.silentsunshine.blueprintsystem.vo.OperatonLogVO;

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
    List<OperatonLogVO> listAllByTaskIdAndNodeId(int taskId);
    int addOperationLog(OperationLog operationLog);
}
