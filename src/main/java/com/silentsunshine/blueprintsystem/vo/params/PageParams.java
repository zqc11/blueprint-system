package com.silentsunshine.blueprintsystem.vo.params;

import lombok.Data;

/**
 * @author zhouqichun
 **/
@Data
public class PageParams {
    private int page = 1;
    private int pageSize = 10;
}
