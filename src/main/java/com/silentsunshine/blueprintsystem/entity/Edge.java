package com.silentsunshine.blueprintsystem.entity;

import java.io.Serializable;

import com.silentsunshine.blueprintsystem.vo.flowchart.EdgeModel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-26
 */
@Data
@NoArgsConstructor
public class Edge implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private Integer taskId;

    /**
     * 边类型
     */
    private String type;

    /**
     * 开始节点id
     */
    private String sourceNodeId;

    /**
     * 结束节点id
     */
    private String targetNodeId;

    /**
     * 出口描述
     */
    private String description;

    /**
     * 出口条件
     */
    private String outCondition;

    private String startPoint;

    private String endPoint;

    private String pointsList;

    public Edge(EdgeModel edgeModel, int taskId){
        this.id = edgeModel.getId();
        this.taskId = taskId;
        this.sourceNodeId = edgeModel.getSourceNodeId();
        this.targetNodeId = edgeModel.getTargetNodeId();
        this.description = edgeModel.getProperties().getDescription();
        this.outCondition = edgeModel.getProperties().getCondition();
        this.startPoint = edgeModel.getStartPoint().toString();
        this.endPoint = edgeModel.getEndPoint().toString();
        this.pointsList = edgeModel.getPointsList().toString();
    }

}
