package cn.hist.greenHouse.controller;

import cn.hist.greenHouse.entity.AlarmRecord;
import cn.hist.greenHouse.service.AlarmRecordService;
import cn.hist.greenHouse.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/al")
public class AlarmRecordController {
    @Autowired
    private AlarmRecordService alarmRecordService;
    @PostMapping("/addAl")
    public ResponseResult add(@RequestBody AlarmRecord alarmRecord){
      return alarmRecordService.addAlarmRecord(alarmRecord);
    }
    @DeleteMapping("/deleteAl")
    public ResponseResult delete(@RequestParam Integer id){
        return alarmRecordService.deleteAlarmRecord(id);
    }
    @PutMapping("/updateAl")
    public ResponseResult update(@RequestBody AlarmRecord alarmRecord){
        return alarmRecordService.updateAlarmRecord(alarmRecord);
    }
    @GetMapping("/getAl")
    public ResponseResult get(@RequestParam Integer id){
        return alarmRecordService.getAlarmRecord(id);
    }
    @GetMapping("/getPages")
    public ResponseResult getPages(@RequestParam Integer gid,@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        Map<String,Object> data = alarmRecordService.getPages(gid, pageNum, pageSize);
        return new ResponseResult(200,"查询成功",data);
    }
}
