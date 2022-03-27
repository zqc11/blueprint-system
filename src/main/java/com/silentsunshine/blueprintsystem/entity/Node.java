package com.silentsunshine.blueprintsystem.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-26
 */
@Getter
@Setter
public class Node implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

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
    private String desc;

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


}
