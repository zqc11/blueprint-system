package com.silentsunshine.blueprintsystem.vo.flowchart;

import lombok.Data;

/**
 * @author zhouqichun
 **/
@Data
public class Point {
    private int x;
    private int y;

    @Override
    public String toString() {
        return "{" + "x:" + x + "," + "y:" + y + "}";
    }
}
