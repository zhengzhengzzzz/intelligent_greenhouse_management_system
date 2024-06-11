package cn.hist.greenHouse.service;

import cn.hist.greenHouse.entity.AlarmRecord;
import cn.hist.greenHouse.util.ResponseResult;

public interface AlarmRecordService {
    ResponseResult addAlarmRecord(AlarmRecord alarmRecord);
    ResponseResult deleteAlarmRecord(Integer id);
    ResponseResult updateAlarmRecord(AlarmRecord alarmRecord);
    ResponseResult getAlarmRecord(Integer id);
}
