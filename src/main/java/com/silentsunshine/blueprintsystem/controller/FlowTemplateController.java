package com.silentsunshine.blueprintsystem.controller;

import com.silentsunshine.blueprintsystem.entity.FlowTemplate;
import com.silentsunshine.blueprintsystem.service.IFlowTemplateService;
import com.silentsunshine.blueprintsystem.vo.FlowTemplateVO;
import com.silentsunshine.blueprintsystem.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
    public Result getAllFlowTemplate(){
        List<FlowTemplateVO> templates = flowTemplateService.getAllFlowTemplate();
        return Result.success(templates);
    }
}
