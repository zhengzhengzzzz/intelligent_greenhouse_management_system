package cn.hist.greenHouse.service;

import cn.hist.greenHouse.entity.ControlStrategy;
import cn.hist.greenHouse.util.ResponseResult;

public interface ControlStrategyService {
    ResponseResult addControlStrategy(ControlStrategy controlStrategy);
    ResponseResult deleteControlStrategy(Integer id);
    ResponseResult updateControlStrategy(ControlStrategy controlStrategy);
    ResponseResult getControlStrategy(Integer id);
}
