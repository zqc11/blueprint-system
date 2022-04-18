package com.silentsunshine.blueprintsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.silentsunshine.blueprintsystem.entity.OperationLog;
import com.silentsunshine.blueprintsystem.vo.OperatonLogVO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-26
 */
public interface OperationLogMapper extends BaseMapper<OperationLog> {
    @Select("select operation_log.modify_date, ft.title, operation_log.checker,operation_log.operation as status from operation_log join node n on operation_log.node_id = n.id and operation_log.task_id = n.task_id join flow_task ft on n.task_id = ft.id where ft.id = ${taskId}")
    List<OperatonLogVO> listAllByTaskIdAndNodeId(int taskId);
}
