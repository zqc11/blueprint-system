package com.silentsunshine.blueprintsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.silentsunshine.blueprintsystem.vo.BlueprintVO;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class Blueprint implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 图纸名称
     */
    private String filename;

    private String location;

    /**
     * 图纸类型
     */
    private String type;

    private Integer taskId;

    private String drawData;

    private String snapData;

    public Blueprint(BlueprintVO blueprintVO, int taskId){
        this.filename = blueprintVO.getFilename();
        this.type = blueprintVO.getType();
        this.location = blueprintVO.getLocation();
        this.taskId = taskId;
    }
}
