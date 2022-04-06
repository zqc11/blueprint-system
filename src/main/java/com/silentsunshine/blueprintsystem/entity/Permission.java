package com.silentsunshine.blueprintsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.util.List;

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
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 权限类型
     */
    private Integer type;

    /**
     * 拥有权限的id
     */
    private String includes;

    /**
     * 任务id
     */
    private Integer taskId;

    public Permission(int type, String includes, int taskId){
        this.type = type;
        this.includes = includes;
        this.taskId = taskId;
    }

}
