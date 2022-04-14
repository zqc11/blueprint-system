package com.silentsunshine.blueprintsystem.vo.flowchart;

import com.silentsunshine.blueprintsystem.entity.Edge;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @author zhouqichun
 **/
@Data
@NoArgsConstructor
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

    public EdgeModel(Edge edge) {
        this.id = edge.getId();
        this.sourceNodeId = edge.getSourceNodeId();
        this.targetNodeId = edge.getTargetNodeId();
        this.text = new Text(edge.getX(), edge.getY(), edge.getValue());
        this.type = edge.getType();
        this.startPoint = Point.parseString2Point(edge.getStartPoint());
        this.endPoint = Point.parseString2Point(edge.getEndPoint());
        this.pointsList = null;
        this.properties = new EdgeProperties(edge.getDescription(), edge.getOutCondition());
    }

}
