package com.silentsunshine.blueprintsystem.controller;

import com.silentsunshine.blueprintsystem.entity.Blueprint;
import com.silentsunshine.blueprintsystem.entity.FlowTask;
import com.silentsunshine.blueprintsystem.service.IBlueprintService;
import com.silentsunshine.blueprintsystem.service.IFlowTaskService;
import com.silentsunshine.blueprintsystem.service.INodeService;
import com.silentsunshine.blueprintsystem.vo.Result;
import com.silentsunshine.blueprintsystem.vo.TaskVO;
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
@RequestMapping("/flowTask")
public class FlowTaskController {
    @Autowired
    INodeService nodeService;

    @Autowired
    IFlowTaskService flowTaskService;

    @Autowired
    IBlueprintService blueprintService;

    @GetMapping("/{id}")
    public Result listTask(@PathVariable("id") Integer id) {
        List<Integer> taskIds = nodeService.getTaskIdByUserId(id);
        List<TaskVO> tasks = new ArrayList<>();
        for (Integer taskId : taskIds) {
            FlowTask flowTask = flowTaskService.getById(taskId);
            List<Blueprint> blueprints = new ArrayList<>();
            String[] blueprintIds = flowTask.getBlueprints().split(",");
            for (int i = 0; i < blueprintIds.length; i++) {
                if (blueprintIds[i].length() == 0) {
                    continue;
                }
                blueprints.add(blueprintService.getById(blueprintIds[i]));
            }
            tasks.add(new TaskVO(flowTask, blueprints));
        }
        tasks.sort(Comparator.comparing(TaskVO::getModifyDate));
        return Result.success(tasks);
    }
}
