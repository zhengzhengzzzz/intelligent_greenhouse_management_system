package cn.hist.greenHouse.mapper;

import cn.hist.greenHouse.entity.AlarmRecord;
import cn.hist.greenHouse.entity.DeviceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AlarmRecordMapper {
    void addAlarmRecord(AlarmRecord alarmRecord);
    void deleteAlarmRecord(Integer id);
    void updateAlarmRecord(AlarmRecord alarmRecord);
    AlarmRecord getAlarmRecord(Integer id);
    Integer getCount(Integer gid);
    List<AlarmRecord> getPages(@Param("gid") Integer gid, @Param("offset") Integer offset, @Param("pageSize") Integer pageSize);
}
