package com.silentsunshine.blueprintsystem.controller;

import com.silentsunshine.blueprintsystem.service.IFlowTemplateService;
import com.silentsunshine.blueprintsystem.vo.FlowTemplateVO;
import com.silentsunshine.blueprintsystem.vo.Result;
import com.silentsunshine.blueprintsystem.vo.params.FlowTemplateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zhouqichun
 * @since 2022-04-14
 */
@RestController
public class FlowTemplateController {
    @Autowired
    IFlowTemplateService flowTemplateService;

    @GetMapping("/getAllFlowTemplate")
    public Result getAllFlowTemplate() {
        List<FlowTemplateVO> templates = flowTemplateService.getAllFlowTemplate();
        return Result.success(templates);
    }

    @PostMapping("/saveFlowTemplate")
    public Result saveFlowTemplate(@RequestBody FlowTemplateParams flowTemplateParams) {
        flowTemplateService.addFlowTemplate(flowTemplateParams);
        return Result.success(null);
    }
}
