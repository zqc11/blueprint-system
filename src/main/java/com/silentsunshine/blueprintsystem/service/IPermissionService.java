package com.silentsunshine.blueprintsystem.service;

import com.silentsunshine.blueprintsystem.entity.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.silentsunshine.blueprintsystem.vo.UserVO;

import java.util.List;
import java.util.Set;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhouqichun
 * @since 2022-03-26
 */
public interface IPermissionService extends IService<Permission> {
    List<Integer> getTaskIds(String userId);
    int insertMaintain(List<UserVO> maintain, int taskId);
    int insertStatistics(List<UserVO> statistics, int taskId);
}
