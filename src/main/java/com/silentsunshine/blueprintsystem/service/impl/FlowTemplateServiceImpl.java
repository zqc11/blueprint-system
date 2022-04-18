package com.silentsunshine.blueprintsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.silentsunshine.blueprintsystem.entity.FlowTemplate;
import com.silentsunshine.blueprintsystem.entity.User;
import com.silentsunshine.blueprintsystem.mapper.FlowTemplateMapper;
import com.silentsunshine.blueprintsystem.service.IFlowTemplateService;
import com.silentsunshine.blueprintsystem.service.IUserService;
import com.silentsunshine.blueprintsystem.vo.FlowTemplateVO;
import com.silentsunshine.blueprintsystem.vo.UserVO;
import com.silentsunshine.blueprintsystem.vo.params.FlowTemplateParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhouqichun
 * @since 2022-04-14
 */
@Service
public class FlowTemplateServiceImpl extends ServiceImpl<FlowTemplateMapper, FlowTemplate> implements IFlowTemplateService {
    @Autowired
    IUserService userService;

    @Override
    public List<FlowTemplateVO> getAllFlowTemplate() {
        List<FlowTemplate> templates = list();
        return templates.stream()
                .map(item -> {
                    User user = userService.getUserById(item.getCreatorId());
                    return new FlowTemplateVO(item, new UserVO(user));
                })
                .collect(Collectors.toList());
    }

    @Override
    public int addFlowTemplate(FlowTemplateParams flowTemplateParams) {
        FlowTemplate flowTemplate = new FlowTemplate(flowTemplateParams);
        return baseMapper.insert(flowTemplate);
    }
}
