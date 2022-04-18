package com.silentsunshine.blueprintsystem.controller;

import com.silentsunshine.blueprintsystem.service.IOperationLogService;
import com.silentsunshine.blueprintsystem.service.impl.FlowTaskServiceImpl;
import com.silentsunshine.blueprintsystem.service.impl.PermissionServiceImpl;
import com.silentsunshine.blueprintsystem.vo.OperatonLogVO;
import com.silentsunshine.blueprintsystem.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-26
 */
@RestController
@RequestMapping("/operationLog")
public class OperationLogController {
    @Autowired
    IOperationLogService operationLogService;

    @Autowired
    PermissionServiceImpl permissionService;

    @Autowired
    FlowTaskServiceImpl flowTaskService;

    @GetMapping("/{id}")
    public Result statistics(@PathVariable String id) {
        // 根据user_id查询permission表获取，用户拥有查看统计信息的task_id
        List<Integer> taskIds = permissionService.getTaskIds(id);
        // 统计集合
        List<OperatonLogVO> operatonLogVOList = new ArrayList<>();
        // 根据task_id查询operation_log表
        for (Integer taskId : taskIds) {
            List<OperatonLogVO> list = operationLogService.listAllByTaskIdAndNodeId(taskId);
            operatonLogVOList.addAll(list);
        }
        operatonLogVOList.sort(Comparator.comparing(OperatonLogVO::getModifyDate));
        return Result.success(operatonLogVOList);
    }
}
