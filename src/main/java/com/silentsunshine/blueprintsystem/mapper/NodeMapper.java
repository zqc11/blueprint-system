package com.silentsunshine.blueprintsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.silentsunshine.blueprintsystem.entity.Node;
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
public interface NodeMapper extends BaseMapper<Node> {
    @Select("select * from node where checkers like '%,${id},%'")
    List<Node> getNodeByUserId(Integer userId);
}
