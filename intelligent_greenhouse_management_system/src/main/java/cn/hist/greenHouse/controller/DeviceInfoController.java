package cn.hist.greenHouse.controller;

import cn.hist.greenHouse.entity.DeviceInfo;
import cn.hist.greenHouse.service.DeviceInfoService;
import cn.hist.greenHouse.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/dev")
public class DeviceInfoController {
    @Autowired
    private DeviceInfoService deviceInfoService;
    @PostMapping("/addDev")
    public ResponseResult addDev(@RequestBody DeviceInfo deviceInfo){
        deviceInfoService.addDeviceInfo(deviceInfo);
        return new ResponseResult(200,"添加设备信息成功");
    }
    @DeleteMapping("/deleteDev")
    public ResponseResult deleteDev(@RequestParam Integer id){
        deviceInfoService.deleteDeviceInfo(id);
        return new ResponseResult(200,"删除设备信息成功");
    }
    @PutMapping("/updateDev")
    public ResponseResult updateDev(@RequestBody DeviceInfo deviceInfo){
        deviceInfoService.updateDeviceInfo(deviceInfo);
        return new ResponseResult(200,"修改设备信息成功");
    }
    @GetMapping("/getDev")
    public ResponseResult getDev(@RequestParam Integer id){
        DeviceInfo data = deviceInfoService.getDeviceInfo(id);
        return new ResponseResult(200,"查询设备信息成功",data);
    }
    @GetMapping("/getPages")
    public ResponseResult getPages(@RequestParam Integer gid,@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        Map<String,Object> data = deviceInfoService.getPages(gid,pageNum,pageSize);
        return new ResponseResult(200,"查询成功",data);
    }
}
