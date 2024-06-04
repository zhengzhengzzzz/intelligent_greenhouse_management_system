package cn.hist.greenHouse.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.util.Date;

@Data
@NoArgsConstructor
public class EnvironmentData {
    private Integer id;
    private Integer gid;
    private Date time;
    private Integer temperature;
    private Integer humidity;
    private Integer CO2;
    private String other;

    public EnvironmentData(Integer gid, Date time, Integer temperature, Integer humidity, Integer CO2, String other) {
        this.gid = gid;
        this.time = time;
        this.temperature = temperature;
        this.humidity = humidity;
        this.CO2 = CO2;
        this.other = other;
    }
}
