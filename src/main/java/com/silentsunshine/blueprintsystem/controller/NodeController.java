package com.silentsunshine.blueprintsystem.controller;

import com.silentsunshine.blueprintsystem.entity.Node;
import com.silentsunshine.blueprintsystem.entity.OperationLog;
import com.silentsunshine.blueprintsystem.service.INodeService;
import com.silentsunshine.blueprintsystem.service.IOperationLogService;
import com.silentsunshine.blueprintsystem.service.IUserService;
import com.silentsunshine.blueprintsystem.vo.Result;
import com.silentsunshine.blueprintsystem.vo.params.NodeParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-26
 */
@RestController
@RequestMapping("/node")
public class NodeController {
    @Autowired
    INodeService nodeService;

    @Autowired
    IUserService userService;

    @Autowired
    IOperationLogService operationLogService;

    @PostMapping("/nodeUpdate")
    public Result nodeUpdate(@RequestBody NodeParams nodeParams) {
        String type = nodeParams.getType();
        int launchOrderNum = nodeParams.getLaunchOrderNum();
        int endOrderNum = nodeParams.getEndOrderNum();
        int taskId = nodeParams.getTaskId();
        String userId = nodeParams.getChecker();
        String userName = userService.getUserById(userId).getName();
        Node node;
        String operation;

        // 首先判断是审批通过还是审批驳回
        if (type.equals("审批通过")) {
            node = nodeService.updateNodeStatus(launchOrderNum, taskId, "已完成");
            nodeService.updateNodeStatus(endOrderNum, taskId, "进行中");
            operation = node.getTitle() + node.getStatus();
        } else {
            for (int i = launchOrderNum; i > endOrderNum; i--) {
                nodeService.updateNodeStatus(i, taskId, "未开始");
            }
            node = nodeService.updateNodeStatus(endOrderNum, taskId, "被驳回");
            operation = node.getTitle() + node.getStatus();
        }
        OperationLog operationLog = new OperationLog(operation, userName, node.getId(), taskId);
        operationLogService.addOperationLog(operationLog);
        // 添加记录到operation_log
        return Result.success(null);
    }
}
