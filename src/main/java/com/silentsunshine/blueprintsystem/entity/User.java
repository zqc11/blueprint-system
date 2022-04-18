package com.silentsunshine.blueprintsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Description
 * @Author zhouqichun
 * @Date 2022-03-22
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"}, ignoreUnknown = true)
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 2218909523104337856L;

    @Id
    @Column(name = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 员工姓名
     */
    @Column(name = "name")
    private String name;

    /**
     * 员工电话
     */
    @Column(name = "mobile")
    private String mobile;

    /**
     * 员工性别
     */
    @Column(name = "gender")
    private Integer gender;

    /**
     * 所在部门
     */
    @Column(name = "department")
    private String department;

    /**
     * 账号
     */
    @Column(name = "account")
    private String account;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

}
