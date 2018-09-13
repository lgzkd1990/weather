package com.zl.weather.reporteureka.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回给前台的天气信息类
 */
@Data
public class WeatherResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	private Weather data;
	private Integer status;
	private String desc;
}
