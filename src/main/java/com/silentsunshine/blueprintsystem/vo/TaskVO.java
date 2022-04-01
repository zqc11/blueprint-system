package com.silentsunshine.blueprintsystem.vo;

import com.silentsunshine.blueprintsystem.entity.Blueprint;
import com.silentsunshine.blueprintsystem.entity.FlowTask;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhouqichun
 **/
@Data
public class TaskVO {
    /**
     * Id
     */
    private Integer id;
    
    /**
     * 任务标题
     */
    private String title;

    /**
     * 描述
     */
    private String description;

    /**
     * 表单json数据
     */
    private String form;

    /**
     * 最近修改时间
     */
    private LocalDateTime modifyDate;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 图纸
     */
    private List<Blueprint> blueprints;


    public TaskVO(FlowTask flowTask, List<Blueprint> blueprints) {
        this.id = flowTask.getId();
        this.title = flowTask.getTitle();
        this.form = flowTask.getForm();
        this.description = flowTask.getDescription();
        this.modifyDate = flowTask.getModifyDate();
        this.createDate = flowTask.getCreateDate();
        this.blueprints = blueprints;
    }
}
