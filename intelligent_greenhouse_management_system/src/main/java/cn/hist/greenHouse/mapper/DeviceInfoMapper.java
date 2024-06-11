package cn.hist.greenHouse.mapper;

import cn.hist.greenHouse.entity.DeviceInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeviceInfoMapper {
    void addDeviceInfo(DeviceInfo deviceInfo);
    void deleteDeviceInfo(Integer id);
    void updateDeviceInfo(DeviceInfo deviceInfo);
    DeviceInfo getDeviceInfo(Integer id);
}
