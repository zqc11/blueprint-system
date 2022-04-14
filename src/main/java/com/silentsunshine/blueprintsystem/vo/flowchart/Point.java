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
public class Point {
    private int x;
    private int y;

    public static Point parseString2Point(String s) {
        int x = 0;
        int y = 0;
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return "{" + "x:" + x + "," + "y:" + y + "}";
    }
}
