package com.silentsunshine.blueprintsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.silentsunshine.blueprintsystem.entity.FlowTask;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-26
 */
public interface FlowTaskMapper extends BaseMapper<FlowTask> {
    @Update("update flow_task set form_data = '${formData}' where id = ${id}")
    int updateFormDataById(@Param("id") int id, @Param("formData") String formData);

}
