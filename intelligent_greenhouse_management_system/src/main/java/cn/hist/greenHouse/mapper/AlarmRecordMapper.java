package cn.hist.greenHouse.mapper;

import cn.hist.greenHouse.entity.AlarmRecord;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AlarmRecordMapper {
    void addAlarmRecord(AlarmRecord alarmRecord);
    void deleteAlarmRecord(Integer id);
    void updateAlarmRecord(AlarmRecord alarmRecord);
    AlarmRecord getAlarmRecord(Integer id);
}
