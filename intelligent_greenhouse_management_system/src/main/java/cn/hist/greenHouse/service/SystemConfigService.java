package cn.hist.greenHouse.service;

import cn.hist.greenHouse.entity.SystemConfig;
import cn.hist.greenHouse.util.ResponseResult;

import java.util.Map;

public interface SystemConfigService {
    ResponseResult addSystemConfig(SystemConfig systemConfig);
    ResponseResult deleteSystemConfig(Integer id);
    ResponseResult updateSystemConfig(SystemConfig systemConfig);
    ResponseResult getSystemConfig(Integer id);
    Map<String,Object> getPages(Integer uid,Integer pageNum,Integer pageSize);
}
