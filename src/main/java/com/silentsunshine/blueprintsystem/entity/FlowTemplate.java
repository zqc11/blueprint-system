package com.silentsunshine.blueprintsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhouqichun
 * @since 2022-04-14
 */
@Getter
@Setter
@TableName("flow_template")
public class FlowTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String title;

    private String description;

    private String creatorId;

    private String json;

    private String maintain;


}
