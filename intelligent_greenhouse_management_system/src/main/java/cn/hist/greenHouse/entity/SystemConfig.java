package cn.hist.greenHouse.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class SystemConfig {
    private Integer id;
    private Integer uid;
    private String key;
    private String value;

    public SystemConfig(Integer uid, String key, String value) {
        this.uid = uid;
        this.key = key;
        this.value = value;
    }
}
