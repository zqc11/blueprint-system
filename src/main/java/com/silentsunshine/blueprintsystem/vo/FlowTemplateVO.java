package com.silentsunshine.blueprintsystem.vo;

import com.silentsunshine.blueprintsystem.entity.FlowTemplate;
import com.silentsunshine.blueprintsystem.utils.Parser;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhouqichun
 **/
@Data
@NoArgsConstructor
public class FlowTemplateVO {
    private int id;
    private String title;
    private String description;
    private UserVO creator;
    private String json;
    private List<String> maintain;

    public FlowTemplateVO(FlowTemplate flowTemplate, UserVO creator){
        this.id = flowTemplate.getId();
        this.title = flowTemplate.getTitle();
        this.description = flowTemplate.getDescription();
        this.creator = creator;
        this.json = flowTemplate.getJson();
        this.maintain = Parser.parseUserId(flowTemplate.getMaintain());
    }
}
