package com.silentsunshine.blueprintsystem.entity;

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
@Table(name = "flowchart")
public class Flowchart implements Serializable {
    private static final long serialVersionUID = 6328232173473678101L;

    @Id
    @Column(name = "id")
    private Long id;

    /**
     * 流程json
     */
    @Column(name = "json")
    private String json;

}
