package com.silentsunshine.blueprintsystem.vo;

import com.silentsunshine.blueprintsystem.entity.OperationLog;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author zhouqichun
 **/
@Data
public class OperatonLogVO {
    private LocalDateTime modifyDate;
    private String title;
    private String checker;
    private String status;

    public OperatonLogVO(OperationLog operationLog, String title){
        this.modifyDate = operationLog.getModifyDate();
        this.title = title;
        this.checker = operationLog.getChecker();
        this.status = operationLog.getOperation();
    }
}
