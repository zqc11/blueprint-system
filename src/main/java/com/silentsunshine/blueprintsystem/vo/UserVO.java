package com.silentsunshine.blueprintsystem.vo;

import com.silentsunshine.blueprintsystem.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhouqichun
 **/
@Data
@NoArgsConstructor
public class UserVO {
    private Long id;

    /**
     * 员工姓名
     */
    private String name;

    /**
     * 员工电话
     */
    private String mobile;

    /**
     * 员工性别
     */
    private Integer gender;

    /**
     * 所在部门
     */
    private String department;

    /**
     * 账号
     */
    private String account;

    /**
     * accessToken
     */
    private String accessToken = "eyJhbGciOiJIUzUxMiJ9.test";

    /**
     * expires token过期时间
     */
    private Long expires = 1800000L * 5;

    public UserVO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.account = user.getAccount();
        this.department = user.getDepartment();
        this.gender = user.getGender();
        this.mobile = user.getMobile();
    }
}
