package cn.hist.greenHouse.service;

import cn.hist.greenHouse.entity.ControlStrategy;
import cn.hist.greenHouse.util.ResponseResult;

import java.util.Map;

public interface ControlStrategyService {
    ResponseResult addControlStrategy(ControlStrategy controlStrategy);
    ResponseResult deleteControlStrategy(Integer id);
    ResponseResult updateControlStrategy(ControlStrategy controlStrategy);
    ResponseResult getControlStrategy(Integer id);
    Map<String,Object> getPages(Integer gid,Integer pageNum,Integer pageSize);
}
