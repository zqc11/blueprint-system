package com.silentsunshine.blueprintsystem.service;

import com.silentsunshine.blueprintsystem.entity.Edge;
import com.baomidou.mybatisplus.extension.service.IService;
import com.silentsunshine.blueprintsystem.vo.flowchart.EdgeModel;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-26
 */
public interface IEdgeService extends IService<Edge> {
    int insertEdges(List<EdgeModel> edges, int taskId);
    List<Edge> getEdgeByTaskId(int taskId);
}
