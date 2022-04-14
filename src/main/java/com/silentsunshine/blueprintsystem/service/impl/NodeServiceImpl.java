package com.silentsunshine.blueprintsystem.service.impl;

import com.silentsunshine.blueprintsystem.entity.Node;
import com.silentsunshine.blueprintsystem.mapper.NodeMapper;
import com.silentsunshine.blueprintsystem.service.INodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.silentsunshine.blueprintsystem.vo.flowchart.NodeModel;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-26
 */
@Service
public class NodeServiceImpl extends ServiceImpl<NodeMapper, Node> implements INodeService {
    @Override
    public List<Node> getNodeByUserId(Integer userId){
        return baseMapper.getNodeByUserId(userId);
    }

    @Override
    public int insertNodes(List<NodeModel> nodes, int taskId){
        int count = 0;
        for (NodeModel node : nodes) {
            Node newNode = new Node(node, taskId);
            count += baseMapper.insert(newNode);
        }
        return count;
    }
}
