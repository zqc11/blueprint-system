package com.silentsunshine.blueprintsystem.vo;

import lombok.Data;

import java.util.List;

/**
 * @author zhouqichun
 * 统计信息
 **/
@Data
public class StatisticsVO {
    /**
     * 操作日志
     */
    private List<OperatonLogVO> operationLogs;
}
