package com.zl.weather.reporteureka.controller;


import com.zl.weather.reporteureka.service.WeatherReportService;
import com.zl.weather.reporteureka.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * 从页面获取天气数据
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {
    private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);


    @Autowired
    private WeatherReportService weatherReportService;


    /**
     * g根据id获取天气
     *
     * @param cityId
     * @param model
     * @return
     * @throws Exception
     */
    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
        // 获取城市ID列表
        // TODO 改为由城市数据API微服务来提供数据
        List<City> cityList = null;

        try {

            // TODO 改为由城市数据API微服务提供数据
            cityList = new ArrayList<>();
            City city = new City();
            city.setCityId("101280601");
            city.setCityName("深圳");
            cityList.add(city);

        } catch (Exception e) {
            logger.error("Exception!", e);
        }

        model.addAttribute("title", "老卫的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }

    /**
     * 根据名称获取天气
     * @param cityName
     * @param model
     * @return
     * @throws Exception
     */
/*    @GetMapping("/cityName/{cityName}")
    public ModelAndView getReportByCityName(@PathVariable("cityName") String cityName, Model model) throws Exception {
        model.addAttribute("title", "lgzkd的天气预报");
        model.addAttribute("cityName", cityName);
        model.addAttribute("cityList", cityDataService.listCity());
        model.addAttribute("report", weatherReportService.getDataByCityName(cityName));
        return new ModelAndView("weather/report", "reportModel", model);
    }*/

}
