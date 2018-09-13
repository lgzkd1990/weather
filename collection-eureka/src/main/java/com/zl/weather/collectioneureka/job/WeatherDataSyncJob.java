package com.zl.weather.collectioneureka.job;

import com.zl.weather.collectioneureka.service.CityClient;
import com.zl.weather.collectioneureka.service.WeatherDataCollectionService;
import com.zl.weather.collectioneureka.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义一个job来气定时获取天气情况：
 * 1、获取城市列表得到城市id
 * 2、遍历城市列表，通过城市id获取城市天气信息
 * 3、将信息储存到redis中
 * 4、log打印同步时开始和结束的信息
 */
public class WeatherDataSyncJob extends QuartzJobBean {
	//打印job的日志
	private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);  

	@Autowired
    WeatherDataCollectionService weatherDataCollectionService;

    @Autowired
    private CityClient cityClient;

	/* (non-Javadoc)
	 * @see org.springframework.scheduling.quartz.QuartzJobBean#executeInternal(org.quartz.JobExecutionContext)
	 */
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("Weather Data Sync Job. Start！");
        // 获取城市ID列表
        List<City> cityList = null;
        try {
            // 由城市数据API微服务提供数据
            cityList = cityClient.listCity();
        } catch (Exception e) {
            logger.error("Exception!", e);
        }
        // 遍历城市ID获取天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            logger.info("Weather Data Sync Job, cityId:" + cityId);
            weatherDataCollectionService.syncDateByCityId(cityId);
        }
		logger.info("Weather Data Sync Job. End！");
	}

}
