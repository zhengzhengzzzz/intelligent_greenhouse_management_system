package cn.hist.greenHouse.mapper;

import cn.hist.greenHouse.entity.DeviceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DeviceInfoMapper {
    void addDeviceInfo(DeviceInfo deviceInfo);
    void deleteDeviceInfo(Integer id);
    void updateDeviceInfo(DeviceInfo deviceInfo);
    DeviceInfo getDeviceInfo(Integer id);
    Integer getCount(Integer gid);
    List<DeviceInfo> getPages(@Param("gid") Integer gid,@Param("offset") Integer offset,@Param("pageSize") Integer pageSize);
}
