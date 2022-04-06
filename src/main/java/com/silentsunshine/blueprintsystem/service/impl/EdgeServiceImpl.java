package com.silentsunshine.blueprintsystem.service.impl;

import com.silentsunshine.blueprintsystem.entity.Edge;
import com.silentsunshine.blueprintsystem.mapper.EdgeMapper;
import com.silentsunshine.blueprintsystem.service.IEdgeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.silentsunshine.blueprintsystem.vo.flowchart.EdgeModel;
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
public class EdgeServiceImpl extends ServiceImpl<EdgeMapper, Edge> implements IEdgeService {

    @Override
    public int insertEdges(List<EdgeModel> edges, int taskId) {
        int count = 0;
        for (EdgeModel edge : edges) {
            Edge newEdge = new Edge(edge, taskId);
            count += baseMapper.insert(newEdge);
        }
        return count;
    }
}
