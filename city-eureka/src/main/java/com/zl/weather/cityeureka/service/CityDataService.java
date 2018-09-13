package com.zl.weather.cityeureka.service;

import com.zl.weather.cityeureka.vo.City;

import java.io.IOException;
import java.util.List;

public interface CityDataService {
    List<City> listCity() throws Exception;
}
