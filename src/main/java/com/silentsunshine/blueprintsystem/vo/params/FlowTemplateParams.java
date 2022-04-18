package com.silentsunshine.blueprintsystem.vo.params;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhouqichun
 **/
@Data
@NoArgsConstructor
public class FlowTemplateParams {
    private String title;
    private String description;
    private String creatorId;
    private String json;
    private List<String> maintain;
}
