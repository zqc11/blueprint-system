package com.silentsunshine.blueprintsystem.vo.flowchart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhouqichun
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EdgeProperties {
    private String description;
    private String condition;
    private String outType;
}
