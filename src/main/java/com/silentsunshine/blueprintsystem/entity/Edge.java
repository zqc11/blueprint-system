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
public class Edge implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 边类型
     */
    private String type;

    /**
     * 开始节点id
     */
    private Integer sourceNodeId;

    /**
     * 结束节点id
     */
    private Integer targetNodeId;


}
