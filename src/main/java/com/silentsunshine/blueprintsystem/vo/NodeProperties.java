package com.silentsunshine.blueprintsystem.vo;

import com.silentsunshine.blueprintsystem.entity.User;
import lombok.Data;

import java.util.List;

/**
 * @author zhouqichun
 **/
@Data
public class NodeProperties {
    /**
     * 节点描述
     */
    private String desc;
    /**
     * 节点状态
     * 未开始、进行中、已完成
     */
    private String status;
    private List<User> checkers;
}
