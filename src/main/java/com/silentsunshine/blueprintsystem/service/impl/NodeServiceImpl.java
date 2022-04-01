package com.silentsunshine.blueprintsystem.service.impl;

import com.silentsunshine.blueprintsystem.entity.Node;
import com.silentsunshine.blueprintsystem.mapper.NodeMapper;
import com.silentsunshine.blueprintsystem.service.INodeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
    public List<Integer> getTaskIdByUserId(Integer userId){
        return baseMapper.getTaskIdByUserId(userId);
    }
}
