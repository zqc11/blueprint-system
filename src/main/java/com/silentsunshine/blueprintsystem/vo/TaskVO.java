package com.silentsunshine.blueprintsystem.vo;

import com.silentsunshine.blueprintsystem.entity.Blueprint;
import com.silentsunshine.blueprintsystem.entity.FlowTask;
import com.silentsunshine.blueprintsystem.vo.params.FlowTaskParams;
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
    private String formJson;

    /**
     * 表单data
     */
    private String formData;

    /**
     * 流程
     */
    private FlowTaskParams.FlowChart flowChart;

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


    public TaskVO(FlowTask flowTask, List<Blueprint> blueprints, FlowTaskParams.FlowChart flowChart) {
        this.id = flowTask.getId();
        this.title = flowTask.getTitle();
        this.formJson = flowTask.getFormJson();
        this.formData = flowTask.getFormData();
        this.description = flowTask.getDescription();
        this.modifyDate = flowTask.getModifyDate();
        this.createDate = flowTask.getCreateDate();
        this.blueprints = blueprints;
        this.flowChart = flowChart;
    }
}
