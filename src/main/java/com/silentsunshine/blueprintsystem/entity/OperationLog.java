package com.silentsunshine.blueprintsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

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
@TableName("operation_log")
public class OperationLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 进行的操作
     */
    private String operation;

    /**
     * 进行操作的人
     */
    private String checker;

    /**
     * 操作时间
     */
    private LocalDateTime modifyDate;

    /**
     * 任务id
     */
    private String nodeId;

    private int taskId;

    public OperationLog(String operation, String userName, String nodeId, int taskId){
        this.operation = operation;
        this.checker = userName;
        this.nodeId = nodeId;
        this.taskId = taskId;
        this.modifyDate = LocalDateTime.now();
    }
}
