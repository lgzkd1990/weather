package com.zl.weather.reporteureka.service;


import com.zl.weather.reporteureka.vo.Weather;

public interface WeatherReportService {

	/**
	 * 根据城市ID查询天气信息
	 * @param cityId
	 * @return
	 */
	Weather getDataByCityId(String cityId);

	//Weather getDataByCityName(String cityName);
}
