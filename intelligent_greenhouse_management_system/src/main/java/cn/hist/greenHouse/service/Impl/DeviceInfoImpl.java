package cn.hist.greenHouse.service.Impl;

import cn.hist.greenHouse.entity.DeviceInfo;
import cn.hist.greenHouse.mapper.DeviceInfoMapper;
import cn.hist.greenHouse.service.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceInfoImpl implements DeviceInfoService {
    @Autowired
    private DeviceInfoMapper deviceInfoMapper;
    @Override
    public void addDeviceInfo(DeviceInfo deviceInfo){
        deviceInfoMapper.addDeviceInfo(deviceInfo);
    }
    @Override
    public void deleteDeviceInfo(Integer id){
        deviceInfoMapper.deleteDeviceInfo(id);
    }
    @Override
    public void updateDeviceInfo(DeviceInfo deviceInfo){
        deviceInfoMapper.updateDeviceInfo(deviceInfo);
    }
    @Override
    public DeviceInfo getDeviceInfo(Integer id){
        return deviceInfoMapper.getDeviceInfo(id);
    }
}
