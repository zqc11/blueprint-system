package com.silentsunshine.blueprintsystem.vo.flowchart;

import lombok.Data;

/**
 * @author zhouqichun
 **/
@Data
public class NodeModel {
    private String id;
    private Text text;
    private String type;
    private int x;
    private int y;
    private NodeProperties properties;

}
