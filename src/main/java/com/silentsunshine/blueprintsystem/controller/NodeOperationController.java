package com.silentsunshine.blueprintsystem.controller;

import com.silentsunshine.blueprintsystem.entity.NodeOperation;
import com.silentsunshine.blueprintsystem.service.INodeOperationService;
import com.silentsunshine.blueprintsystem.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhouqichun
 * @since 2022-04-19
 */
@RestController
public class NodeOperationController {
    @Autowired
    INodeOperationService nodeOperationService;

    @GetMapping("/getAllOperations")
    public Result getAllOperations() {
        List<NodeOperation> operations = nodeOperationService.list();
        return Result.success(operations);
    }

    @GetMapping("/getOperationById/{id}")
    public Result getOperationById(@PathVariable("id") int id) {
        NodeOperation nodeOperation = nodeOperationService.getById(id);
        return Result.success(nodeOperation);
    }
}
