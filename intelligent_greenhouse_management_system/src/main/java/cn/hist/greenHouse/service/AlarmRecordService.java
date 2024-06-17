package cn.hist.greenHouse.service;

import cn.hist.greenHouse.entity.AlarmRecord;
import cn.hist.greenHouse.util.ResponseResult;

import java.util.Map;

public interface AlarmRecordService {
    ResponseResult addAlarmRecord(AlarmRecord alarmRecord);
    ResponseResult deleteAlarmRecord(Integer id);
    ResponseResult updateAlarmRecord(AlarmRecord alarmRecord);
    ResponseResult getAlarmRecord(Integer id);
    Map<String,Object> getPages(Integer gid,Integer pageNum,Integer pageSize);
}
