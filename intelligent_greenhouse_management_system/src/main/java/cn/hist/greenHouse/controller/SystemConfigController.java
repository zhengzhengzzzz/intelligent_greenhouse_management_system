package cn.hist.greenHouse.controller;

import cn.hist.greenHouse.entity.SystemConfig;
import cn.hist.greenHouse.service.SystemConfigService;
import cn.hist.greenHouse.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/sys")
public class SystemConfigController {
   @Autowired
    private SystemConfigService systemConfigService;
   @PostMapping("/add")
    public ResponseResult add(@RequestBody SystemConfig systemConfig){
       return systemConfigService.addSystemConfig(systemConfig);
   }
   @DeleteMapping("/delete")
    public ResponseResult delete(@RequestParam Integer id){
       return systemConfigService.deleteSystemConfig(id);
   }
   @PutMapping("/update")
    public ResponseResult update(@RequestBody SystemConfig systemConfig){
       return systemConfigService.updateSystemConfig(systemConfig);
   }
   @GetMapping("/get")
    public ResponseResult get(@RequestParam Integer id){
       return systemConfigService.getSystemConfig(id);
   }
   @GetMapping("/getPages")
    public ResponseResult getPages(@RequestParam Integer uid,@RequestParam Integer pageNum,@RequestParam Integer pageSize){
       Map<String,Object> data = systemConfigService.getPages(uid, pageNum, pageSize);
       return new ResponseResult(200,"查询成功",data);
   }
}
