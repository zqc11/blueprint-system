package com.silentsunshine.blueprintsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.silentsunshine.blueprintsystem.entity.Permission;
import org.apache.ibatis.annotations.Param;
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
public interface PermissionMapper extends BaseMapper<Permission> {
    @Select("select * from permission where type=1 and includes like '%,${id},%'")
    List<Permission> getStatisticsByUserId(@Param("id") String id);
}
