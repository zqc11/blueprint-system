package com.silentsunshine.blueprintsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.silentsunshine.blueprintsystem.entity.FlowTask;
import com.silentsunshine.blueprintsystem.mapper.FlowTaskMapper;
import com.silentsunshine.blueprintsystem.service.IFlowTaskService;
import com.silentsunshine.blueprintsystem.vo.params.FlowTaskParams;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-26
 */
@Service
public class FlowTaskServiceImpl extends ServiceImpl<FlowTaskMapper, FlowTask> implements IFlowTaskService {
    @Override
    public int insertBackAutoId(FlowTaskParams flowTaskParams) {
        FlowTaskParams.BaseInfo baseInfo = flowTaskParams.getBaseInfo();
        LocalDateTime now = LocalDateTime.now();
        FlowTask flowTask = new FlowTask(baseInfo.getTitle(), baseInfo.getDesc(), null, now, now);
        baseMapper.insert(flowTask);
        return flowTask.getId();
    }

    @Override
    public int updateFormDataById(int id, String formData) {
        return baseMapper.updateFormDataById(id, formData);
    }

    @Override
    public int updateFormJsonById(int id, String formJson) {
        return baseMapper.updateFormJsonById(id, formJson);
    }
}
