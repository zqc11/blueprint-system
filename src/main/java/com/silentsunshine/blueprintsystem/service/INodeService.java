package com.silentsunshine.blueprintsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.silentsunshine.blueprintsystem.entity.Node;
import com.silentsunshine.blueprintsystem.vo.flowchart.NodeModel;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-26
 */
public interface INodeService extends IService<Node> {
    List<Node> getNodeByUserId(Integer userId);
    int insertNodes(List<NodeModel> nodes, int taskId);
    Node updateNodeStatus(int orderNum, int taskId, String status);
}
