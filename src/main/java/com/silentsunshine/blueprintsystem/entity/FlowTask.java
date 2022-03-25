package com.silentsunshine.blueprintsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-25
 */
@Getter
@Setter
@TableName("flow_task")
public class FlowTask implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 任务id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 任务标题
     */
    private String title;

    /**
     * 任务描述
     */
    private String desc;

    /**
     * 图纸id
     */
    private String blueprints;

    /**
     * 表单json
     */
    private String form;

    /**
     * 流程json
     */
    private String flowchart;

    /**
     * 维护权限id
     */
    private Integer maintainPermissionId;

    /**
     * 统计权限id
     */
    private Integer statisticsPermissionId;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 最近修改时间
     */
    private LocalDateTime modifyDate;


}
