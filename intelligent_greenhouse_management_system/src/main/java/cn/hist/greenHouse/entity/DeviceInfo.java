package cn.hist.greenHouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceInfo {
    private Integer id;
    private Integer gid;
    private String name;
    private String type;
    private String status;

    public DeviceInfo(Integer gid, String name, String type, String status) {
        this.gid = gid;
        this.name = name;
        this.type = type;
        this.status = status;
    }
}
