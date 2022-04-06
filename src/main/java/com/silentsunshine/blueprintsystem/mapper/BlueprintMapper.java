package com.silentsunshine.blueprintsystem.mapper;

import com.silentsunshine.blueprintsystem.entity.Blueprint;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-26
 */
public interface BlueprintMapper extends BaseMapper<Blueprint> {
    @Select("select * from blueprint where task_id = ${taskId}")
    List<Blueprint> getAllByTaskId(@Param("taskId") int taskId);
}
