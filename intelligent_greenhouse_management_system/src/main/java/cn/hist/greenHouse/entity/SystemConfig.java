package cn.hist.greenHouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SystemConfig {
    private Integer id;
    private Integer uid;
    private String key;
    private String value;
}
