package cn.hist.greenHouse.controller;

import cn.hist.greenHouse.entity.EnvironmentData;
import cn.hist.greenHouse.service.EnvironmentDataService;
import cn.hist.greenHouse.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/env")
public class EnvironmentDataController {
    @Autowired
    private EnvironmentDataService environmentDataService;
    @PostMapping("/addEnv")
    public ResponseResult addEnvironmentData(@RequestBody EnvironmentData environmentData){
        environmentDataService.addEnvironmentData(environmentData);
        return new ResponseResult(200,"添加环境参数成功");
    }
    @PutMapping("/updateEnv")
    public ResponseResult updateEnvironmentData(@RequestBody EnvironmentData environmentData){
        environmentDataService.updateEnvironmentData(environmentData);
        return new ResponseResult(200,"修改环境参数成功");
    }
    @DeleteMapping("/deleteEnv")
    public ResponseResult deleteEnvironmentData(@RequestParam Integer id){
        environmentDataService.deleteEnvironmentData(id);
        return new ResponseResult(200,"删除环境参数成功");
    }
    @GetMapping("/getLatest")
    public ResponseResult getLatest(@RequestParam Integer gid){
        EnvironmentData data = environmentDataService.getlatest(gid);
        return new ResponseResult(200,"查询成功",data);
    }
    @GetMapping("/getEnvDatas")
    public ResponseResult getEnvDatas(Integer gid){
        List<Map<String,Object>> data = environmentDataService.getEnvData(gid);

// 创建温度、湿度、CO2 和其他字段的 Map
        ArrayList temperaturelist = new ArrayList();
        ArrayList humiditylist = new ArrayList();
        ArrayList co2list = new ArrayList();
        ArrayList otherlist = new ArrayList();
        ArrayList timelist = new ArrayList();

        for (Map<String, Object> row : data) {
            // 获取每个字段的值
            Integer temperature = (Integer) row.get("temperature");
            Integer humidity = (Integer) row.get("humidity");
            Integer co2 = (Integer) row.get("co2");
            String other = (String) row.get("other");
            Timestamp time = (Timestamp) row.get("time");

            // 将值放入对应的 Map 中
            temperaturelist.add(temperature);
            humiditylist.add( humidity);
            co2list.add(co2);
            otherlist.add(other);
            timelist.add(time.toLocalDateTime().toString().replace("T", " "));
        }

        Map<String, Object> res = new HashMap<>();
        res.put("temperature",temperaturelist);
        res.put("humidity",humiditylist);
        res.put("co2",co2list);
        res.put("other",otherlist);
        res.put("time",timelist);
        return new ResponseResult(200,"查询成功",res);
    }
    @GetMapping("/getPages")
    public ResponseResult getPages(@RequestParam Integer gid,@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        Map<String, Object> data = environmentDataService.getPages(gid,pageNum,pageSize);
        return new ResponseResult(200,"查询成功",data);
    }
}
