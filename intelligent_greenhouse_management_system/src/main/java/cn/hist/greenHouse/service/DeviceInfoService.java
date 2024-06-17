package cn.hist.greenHouse.service;

import cn.hist.greenHouse.entity.DeviceInfo;

import java.util.Map;

public interface DeviceInfoService {
    void addDeviceInfo(DeviceInfo deviceInfo);
    void deleteDeviceInfo(Integer id);
    void updateDeviceInfo(DeviceInfo deviceInfo);
    DeviceInfo getDeviceInfo(Integer id);
    Map<String,Object> getPages(Integer gid, Integer pageNum, Integer pageSize);
}
