package com.silentsunshine.blueprintsystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.silentsunshine.blueprintsystem.entity.Blueprint;
import com.silentsunshine.blueprintsystem.vo.BlueprintVO;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-26
 */
public interface IBlueprintService extends IService<Blueprint> {
    List<Blueprint> getAllByTaskId(int taskId);

    int insertBlueprint(BlueprintVO blueprint, int taskId);

    int updateDrawData(int id, String drawData);

    int updateSnapData(int id, String snapData);

    String getDrawData(int id);

    String getSnapData(int id);
}
