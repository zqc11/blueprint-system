package com.silentsunshine.blueprintsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.silentsunshine.blueprintsystem.entity.Node;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-26
 */
public interface NodeMapper extends BaseMapper<Node> {
    @Select("select * from node where checkers like '%,${id},%'")
    List<Node> getNodeByUserId(Integer userId);

    @Update("update node set status = '${status}' where order_num = '${orderNum}' and task_id = ${taskId}")
    int updateNodeStatus(int orderNum, int taskId, String status);

    @Select("select * from node where order_num = ${orderNum} and task_id = ${taskId}")
    Node getNodeByOrderNumAndTaskId(int orderNum, int taskId);
}
