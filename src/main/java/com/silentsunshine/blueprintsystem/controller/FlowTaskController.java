package com.silentsunshine.blueprintsystem.controller;

import com.silentsunshine.blueprintsystem.entity.Blueprint;
import com.silentsunshine.blueprintsystem.entity.Edge;
import com.silentsunshine.blueprintsystem.entity.FlowTask;
import com.silentsunshine.blueprintsystem.entity.Node;
import com.silentsunshine.blueprintsystem.service.*;
import com.silentsunshine.blueprintsystem.utils.Parser;
import com.silentsunshine.blueprintsystem.vo.Result;
import com.silentsunshine.blueprintsystem.vo.TaskVO;
import com.silentsunshine.blueprintsystem.vo.flowchart.EdgeModel;
import com.silentsunshine.blueprintsystem.vo.flowchart.NodeModel;
import com.silentsunshine.blueprintsystem.vo.params.FlowTaskParams;
import com.silentsunshine.blueprintsystem.vo.params.FormDataParams;
import com.silentsunshine.blueprintsystem.vo.params.FormJsonParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        List<Node> nodes = nodeService.getNodeByUserId(id);
        List<TaskVO> tasks = new ArrayList<>();
        Set<Integer> taskIdSet = nodes.stream().map(Node::getTaskId).collect(Collectors.toSet());

        for (Integer taskId : taskIdSet) {
            FlowTask flowTask = flowTaskService.getById(taskId);
            List<Node> nodeList = nodeService.getNodeByTaskId(taskId);
            List<Edge> edgeList = edgeService.getEdgeByTaskId(taskId);
            FlowTaskParams.FlowChart flowChart = new FlowTaskParams.FlowChart(nodeList, edgeList);
            List<Blueprint> blueprints = blueprintService.getAllByTaskId(taskId);
            tasks.add(new TaskVO(flowTask, blueprints, flowChart));
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

        // Permission
        FlowTaskParams.Permission permission = flowTaskParams.getPermission();
        List<String> maintain = permission.getMaintain();
        List<String> statistics = permission.getStatistics();
        permissionService.insertMaintain(maintain, taskId);
        permissionService.insertStatistics(statistics, taskId);

        return Result.success(null);
    }

    @PostMapping("/saveFormData")
    public Result saveFormData(@RequestBody FormDataParams formDataParams) {
        int id = formDataParams.getId();
        String formData = formDataParams.getFormData();
        String newFormData = Parser.convertJsonStringfy(formData);
        flowTaskService.updateFormDataById(id, newFormData);
        return Result.success(null);
    }

    @PostMapping("/saveFormJson")
    public Result saveFormJson(@RequestBody FormJsonParams formJsonParams) {
        int id = formJsonParams.getTaskId();
        String formJson = formJsonParams.getJson();
        String convertFormJson = Parser.convertJsonStringfy(formJson);
        flowTaskService.updateFormJsonById(id, convertFormJson);
        return Result.success(null);
    }

}
