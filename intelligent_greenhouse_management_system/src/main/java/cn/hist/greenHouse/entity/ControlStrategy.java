package cn.hist.greenHouse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ControlStrategy {
    private Integer id;
    private Integer gid;
    private String parameter;
    private Integer min;
    private Integer max;
    private String action;
}
