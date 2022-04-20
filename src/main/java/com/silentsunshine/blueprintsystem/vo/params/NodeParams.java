package com.silentsunshine.blueprintsystem.vo.params;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhouqichun
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NodeParams {
    private int launchOrderNum;
    private int endOrderNum;
    private int taskId;
    private String type;
    private String checker;
    private String condition;
    private Boolean complete;
}
