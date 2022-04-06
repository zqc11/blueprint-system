package com.silentsunshine.blueprintsystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.silentsunshine.blueprintsystem.entity.Blueprint;
import com.silentsunshine.blueprintsystem.mapper.BlueprintMapper;
import com.silentsunshine.blueprintsystem.service.IBlueprintService;
import com.silentsunshine.blueprintsystem.vo.BlueprintVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-26
 */
@Service
public class BlueprintServiceImpl extends ServiceImpl<BlueprintMapper, Blueprint> implements IBlueprintService {

    @Override
    public List<Blueprint> getAllByTaskId(int taskId) {
        return baseMapper.getAllByTaskId(taskId);
    }

    @Override
    public int insertBlueprints(List<BlueprintVO> blueprints, int taskId) {
        int count = 0;
//        if (blueprints == null || blueprints.size() == 0) {
//            return count;
//        }
        for (BlueprintVO blueprint : blueprints) {
            Blueprint newBlueprint = new Blueprint(blueprint, taskId);
            count += baseMapper.insert(newBlueprint);
        }
        return count;
    }
}
