package com.silentsunshine.blueprintsystem.service;

import com.silentsunshine.blueprintsystem.entity.FlowTask;
import com.baomidou.mybatisplus.extension.service.IService;
import com.silentsunshine.blueprintsystem.vo.params.FlowTaskParams;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-26
 */
public interface IFlowTaskService extends IService<FlowTask> {
    int insertBackAutoId(FlowTaskParams flowTaskParams);
    int updateFormDataById(int id, String formData);
    int updateFormJsonById(int id, String formJson);
}
