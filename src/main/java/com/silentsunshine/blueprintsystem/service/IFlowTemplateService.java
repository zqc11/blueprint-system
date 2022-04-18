package com.silentsunshine.blueprintsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.silentsunshine.blueprintsystem.entity.FlowTemplate;
import com.silentsunshine.blueprintsystem.vo.FlowTemplateVO;
import com.silentsunshine.blueprintsystem.vo.params.FlowTemplateParams;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhouqichun
 * @since 2022-04-14
 */
public interface IFlowTemplateService extends IService<FlowTemplate> {
    List<FlowTemplateVO> getAllFlowTemplate();

    int addFlowTemplate(FlowTemplateParams flowTemplateParams);
}
