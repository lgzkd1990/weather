package com.zl.weather.dataeureka.service;

import com.zl.weather.dataeureka.vo.WeatherResponse;

public interface WeatherDataService {


    WeatherResponse getDataByCityId(String cityId);

    WeatherResponse getDataByCityName(String cityName);
}
