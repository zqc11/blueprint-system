package com.silentsunshine.blueprintsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.NoArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  
 * @Author  zhouqichun
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
@Table ( name ="flow_task" )
public class FlowTask  implements Serializable {
	private static final long serialVersionUID =  5486364759702110242L;

	/**
	 * 任务id
	 */
	@Id
	@Column(name = "id" )
	private Long id;

	/**
	 * 任务标题
	 */
   	@Column(name = "title" )
	private String title;

	/**
	 * 任务描述
	 */
   	@Column(name = "desc" )
	private String desc;

	/**
	 * 图纸id
	 */
   	@Column(name = "blueprint_id" )
	private Long blueprintId;

	/**
	 * 表单id
	 */
   	@Column(name = "form_id" )
	private Long formId;

	/**
	 * 流程id
	 */
   	@Column(name = "flowchart_id" )
	private Long flowchartId;

	/**
	 * 维护权限
	 */
   	@Column(name = "maintain_permission" )
	private Integer maintainPermission;

	/**
	 * 统计权限
	 */
   	@Column(name = "statistics_permission" )
	private Integer statisticsPermission;

}
