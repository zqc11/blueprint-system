package com.silentsunshine.blueprintsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.silentsunshine.blueprintsystem.utils.Parser;
import com.silentsunshine.blueprintsystem.vo.params.FlowTemplateParams;
import lombok.AllArgsConstructor;
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
 * @since 2022-04-14
 */
@Getter
@Setter
@TableName("flow_template")
@NoArgsConstructor
@AllArgsConstructor
public class FlowTemplate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String title;

    private String description;

    private String creatorId;

    private String json;

    private String maintain;


    public FlowTemplate(FlowTemplateParams flowTemplateParams) {
        this.title = flowTemplateParams.getTitle();
        this.description = flowTemplateParams.getDescription();
        this.creatorId = flowTemplateParams.getCreatorId();
        this.json = Parser.convertJsonStringfy(flowTemplateParams.getJson());
        this.maintain = Parser.unparse(flowTemplateParams.getMaintain());
    }
}
