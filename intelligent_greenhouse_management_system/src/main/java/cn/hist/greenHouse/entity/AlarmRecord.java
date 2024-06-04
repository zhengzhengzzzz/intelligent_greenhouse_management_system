package cn.hist.greenHouse.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class AlarmRecord {
    private Integer id;
    private Integer gid;
    private Date time;
    private String parameter;
    private String value;
    private String actionTaken;

    public AlarmRecord(Integer gid, Date time, String parameter, String value, String actionTaken) {
        this.gid = gid;
        this.time = time;
        this.parameter = parameter;
        this.value = value;
        this.actionTaken = actionTaken;
    }
}
