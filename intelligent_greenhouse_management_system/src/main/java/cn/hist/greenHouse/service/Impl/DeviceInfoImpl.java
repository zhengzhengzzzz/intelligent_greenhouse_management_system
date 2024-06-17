package cn.hist.greenHouse.service.Impl;

import cn.hist.greenHouse.entity.DeviceInfo;
import cn.hist.greenHouse.entity.EnvironmentData;
import cn.hist.greenHouse.mapper.DeviceInfoMapper;
import cn.hist.greenHouse.service.DeviceInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
    @Override
    public Map<String,Object> getPages(Integer gid,Integer pageNum,Integer pageSize){
        Integer offset = (pageNum - 1) * pageSize; //计算偏移量
        List<DeviceInfo> list = deviceInfoMapper.getPages(gid, offset, pageSize);
        Integer totalCount = deviceInfoMapper.getCount(gid);
        Integer totalPages = (totalCount + pageSize - 1) / pageSize;

        Map<String,Object> data = new TreeMap<>();
        data.put("list",list);
        data.put("currentPage",pageNum);
        data.put("totalCount",totalCount);
        data.put("totalPages",totalPages);
        return data;
    }
}
