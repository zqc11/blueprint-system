package com.silentsunshine.blueprintsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.silentsunshine.blueprintsystem.entity.Blueprint;
import org.apache.ibatis.annotations.Param;
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
public interface BlueprintMapper extends BaseMapper<Blueprint> {
    @Select("select * from blueprint where task_id = ${taskId};")
    List<Blueprint> getAllByTaskId(@Param("taskId") int taskId);

    @Update("update blueprint set draw_data = '${drawData}' where id = ${id};")
    int updateDrawDataById(@Param("id") int id, @Param("drawData") String drawData);

    @Update("update blueprint set snap_data = '${snapData}' where id = ${id};")
    int updateSnapDataById(@Param("id") int id, @Param("snapData") String snapData);

    @Select("select draw_data from blueprint where id = ${id};")
    String getDrawDataById(@Param("id") int id);

    @Select("select snap_data from blueprint where id = ${id};")
    String getSnapDataById(@Param("id") int id);
}
