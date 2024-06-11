package cn.hist.greenHouse.service.Impl;

import cn.hist.greenHouse.entity.AlarmRecord;
import cn.hist.greenHouse.mapper.AlarmRecordMapper;
import cn.hist.greenHouse.service.AlarmRecordService;
import cn.hist.greenHouse.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlarmRecordServiceImpl implements AlarmRecordService {
    @Autowired
    private AlarmRecordMapper alarmRecordMapper;
    @Override
    public ResponseResult addAlarmRecord(AlarmRecord alarmRecord){
        if(alarmRecord.getGid() == null){
            return new ResponseResult(404,"请传入温室ID");
        }
        alarmRecordMapper.addAlarmRecord(alarmRecord);
        return new ResponseResult(200,"添加成功");
    }
    @Override
    public ResponseResult deleteAlarmRecord(Integer id){
        if(id == null){
            return new ResponseResult(404,"请传入ID");
        }
        AlarmRecord al = alarmRecordMapper.getAlarmRecord(id);
        if(al==null){
            return new ResponseResult(404,"请传入正确的ID");
        }
        alarmRecordMapper.deleteAlarmRecord(id);
        return new ResponseResult(200,"删除警报记录成功");
    }
    @Override
    public ResponseResult updateAlarmRecord(AlarmRecord alarmRecord){
        if(alarmRecord.getId() == null){
            return new ResponseResult(404,"请传入ID");
        }
        if(alarmRecord.getGid() == null){
            return new ResponseResult(404,"请传入温室ID");
        }
        alarmRecordMapper.updateAlarmRecord(alarmRecord);
        return new ResponseResult(200,"修改警报记录成功");
    }
    @Override
    public ResponseResult getAlarmRecord(Integer id){
        if(id == null){
            return new ResponseResult(404,"请传入ID");
        }
        AlarmRecord data = alarmRecordMapper.getAlarmRecord(id);
        if(data == null) {
            return new ResponseResult(404,"未找到");
        }
        return new ResponseResult(200,"查询警报记录成功",data);
    }
}
