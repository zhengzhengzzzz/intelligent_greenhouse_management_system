package cn.hist.greenHouse.service;

import cn.hist.greenHouse.entity.DeviceInfo;

public interface DeviceInfoService {
    void addDeviceInfo(DeviceInfo deviceInfo);
    void deleteDeviceInfo(Integer id);
    void updateDeviceInfo(DeviceInfo deviceInfo);
    DeviceInfo getDeviceInfo(Integer id);
}
