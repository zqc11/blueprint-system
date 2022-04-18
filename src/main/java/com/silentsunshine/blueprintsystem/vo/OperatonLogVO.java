package com.silentsunshine.blueprintsystem.vo;

import com.silentsunshine.blueprintsystem.entity.OperationLog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author zhouqichun
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperatonLogVO {
    private LocalDateTime modifyDate;
    private String title;
    private String checker;
    private String status;

    public OperatonLogVO(OperationLog operationLog, String title) {
        this.modifyDate = operationLog.getModifyDate();
        this.title = title;
        this.checker = operationLog.getChecker();
        this.status = operationLog.getOperation();
    }
}
