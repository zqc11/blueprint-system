package com.silentsunshine.blueprintsystem.entity;

import com.silentsunshine.blueprintsystem.utils.Parser;
import com.silentsunshine.blueprintsystem.vo.flowchart.NodeModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
public class Node implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 节点类型
     */
    private String type;

    /**
     * 节点中心x轴坐标
     */
    private Integer x;

    /**
     * 节点中心y轴坐标
     */
    private Integer y;

    /**
     * 文本内容：text.value
     */
    private String title;

    /**
     * 文本中心x轴坐标: text.x
     */
    private Integer textX;

    /**
     * 文本中心y轴坐标: text.y
     */
    private Integer textY;

    /**
     * 节点描述: properties.desc
     */
    private String description;

    /**
     * 审批人id列表，逗号分割: properties.checkers
     */
    private String checkers;

    /**
     * 节点状态: properties.status
     */
    private String status;

    /**
     * 任务id
     */
    private Integer taskId;

    private String hasRejected;

    private String hasPassed;

    /**
     * 顺序
     */
    private int orderNum;

    public Node(NodeModel nodeModel, int taskId) {
        this.id = nodeModel.getId();
        this.taskId = taskId;
        this.description = nodeModel.getProperties().getDescription();
        this.status = nodeModel.getProperties().getStatus();
        this.orderNum = nodeModel.getProperties().getOrderNum();
        this.x = nodeModel.getX();
        this.y = nodeModel.getY();
        this.type = nodeModel.getType();
        this.title = nodeModel.getText().getValue();
        this.textX = nodeModel.getText().getX();
        this.textY = nodeModel.getText().getY();
        this.checkers = Parser.unparse(nodeModel.getProperties().getCheckers());
    }

}
