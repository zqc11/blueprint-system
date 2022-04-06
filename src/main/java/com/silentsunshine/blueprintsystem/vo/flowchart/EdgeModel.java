package com.silentsunshine.blueprintsystem.vo.flowchart;

import lombok.Data;

import java.util.List;


/**
 * @author zhouqichun
 **/
@Data
public class EdgeModel {
    private String id;
    private String sourceNodeId;
    private String targetNodeId;
    private Text text;
    private String type;
    private Point startPoint;
    private Point endPoint;
    private List<Point> pointsList;
    private EdgeProperties properties;
}
