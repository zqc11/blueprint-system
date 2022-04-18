package com.silentsunshine.blueprintsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

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
    private String description;

    /**
     * 表单json
     */
    private String formJson;

    /**
     * 表单data
     */
    private String formData;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 最近修改时间
     */
    private LocalDateTime modifyDate;

    public FlowTask(String title, String description, String formJson, LocalDateTime createDate, LocalDateTime modifyDate) {
        this.title = title;
        this.description = description;
        this.formJson = formJson;
        this.createDate = createDate;
        this.modifyDate = modifyDate;
    }
}
