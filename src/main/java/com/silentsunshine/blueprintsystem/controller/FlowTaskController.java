package com.silentsunshine.blueprintsystem.controller;

import com.silentsunshine.blueprintsystem.entity.Blueprint;
import com.silentsunshine.blueprintsystem.entity.FlowTask;
import com.silentsunshine.blueprintsystem.service.*;
import com.silentsunshine.blueprintsystem.vo.BlueprintVO;
import com.silentsunshine.blueprintsystem.vo.Result;
import com.silentsunshine.blueprintsystem.vo.TaskVO;
import com.silentsunshine.blueprintsystem.vo.UserVO;
import com.silentsunshine.blueprintsystem.vo.flowchart.EdgeModel;
import com.silentsunshine.blueprintsystem.vo.flowchart.NodeModel;
import com.silentsunshine.blueprintsystem.vo.params.FlowTaskParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/flowTask")
public class FlowTaskController {
    @Autowired
    INodeService nodeService;

    @Autowired
    IEdgeService edgeService;

    @Autowired
    IFlowTaskService flowTaskService;

    @Autowired
    IBlueprintService blueprintService;

    @Autowired
    IPermissionService permissionService;

    @GetMapping("/{id}")
    public Result listTask(@PathVariable("id") Integer id) {
        List<Integer> taskIds = nodeService.getTaskIdByUserId(id);
        List<TaskVO> tasks = new ArrayList<>();
        for (Integer taskId : taskIds) {
            FlowTask flowTask = flowTaskService.getById(taskId);
            List<Blueprint> blueprints = blueprintService.getAllByTaskId(taskId);
            tasks.add(new TaskVO(flowTask, blueprints));
        }
        tasks.sort(Comparator.comparing(TaskVO::getModifyDate));
        return Result.success(tasks);
    }

    @PostMapping("/saveTask")
    public Result saveTask(@RequestBody FlowTaskParams flowTaskParams) {
        FlowTaskParams.FlowChart flowChart = flowTaskParams.getFlowChart();
        // FlowTask
        int taskId = flowTaskService.insertBackAutoId(flowTaskParams);

        // Node
        List<NodeModel> nodes = flowChart.getNodes();
        nodeService.insertNodes(nodes, taskId);

        // Edge
        List<EdgeModel> edges = flowChart.getEdges();
        edgeService.insertEdges(edges, taskId);

        // Blueprint
        List<BlueprintVO> blueprints = flowTaskParams.getBlueprints();
        blueprintService.insertBlueprints(blueprints, taskId);

        // Permission
        FlowTaskParams.Permission permission = flowTaskParams.getPermission();
        List<UserVO> maintain = permission.getMaintain();
        List<UserVO> statistics = permission.getStatistics();
        permissionService.insertMaintain(maintain, taskId);
        permissionService.insertStatistics(statistics, taskId);

        return Result.success(null);
    }
}
