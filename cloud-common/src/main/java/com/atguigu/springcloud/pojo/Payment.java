package com.atguigu.springcloud.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/****
 * @Author:shenkunlin
 * @Description:Payment构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Payment",value = "Payment")
@Table(name="payment")
public class Payment implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @Column(name = "id")
	private Long id;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "serial")
	private String serial;//



	//get方法
	public Long getId() {
		return id;
	}

	//set方法
	public void setId(Long id) {
		this.id = id;
	}
	//get方法
	public String getSerial() {
		return serial;
	}

	//set方法
	public void setSerial(String serial) {
		this.serial = serial;
	}


}
