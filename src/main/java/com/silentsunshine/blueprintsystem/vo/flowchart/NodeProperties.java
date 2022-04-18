package com.silentsunshine.blueprintsystem.vo.flowchart;

import com.silentsunshine.blueprintsystem.vo.UserVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhouqichun
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NodeProperties {
    /**
     * 节点描述
     */
    private String description;
    /**
     * 节点状态
     * 未开始、进行中、已完成
     */
    private String status;
    private int orderNum;
    private List<String> checkers;
    private List<String> hasPassed;
    private List<String> hasRejected;
}
