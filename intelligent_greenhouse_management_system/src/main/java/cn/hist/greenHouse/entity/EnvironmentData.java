package cn.hist.greenHouse.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnvironmentData {
    private Integer id;
    private Integer gid;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;
    private Integer temperature;
    private Integer humidity;
    private Integer co2;
    private String other;
}
