package mcp.example.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Z.W.H
 * @version 1.0.0
 * @date2026/1/5 9:54
 * @description: CurrentTimeTools
 */
@Component
public class CurrentTimeTools {

    private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 获取当前时间并格式化为字符串
     * @return 格式化后的当前时间字符串
     */
    @Tool(description = "Get the current time")
    public String getCurrentTime() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(DEFAULT_FORMATTER);
    }

    /**
     * 获取当前时间并返回时间信息的Map
     * @return 包含当前时间相关信息的Map
     */
    public Map<String, Object> getCurrentTimeInfo() {
        LocalDateTime now = LocalDateTime.now();
        Map<String, Object> timeInfo = new HashMap<>();
        timeInfo.put("currentTime", now.format(DEFAULT_FORMATTER));
        timeInfo.put("year", now.getYear());
        timeInfo.put("month", now.getMonthValue());
        timeInfo.put("day", now.getDayOfMonth());
        timeInfo.put("hour", now.getHour());
        timeInfo.put("minute", now.getMinute());
        timeInfo.put("second", now.getSecond());
        return timeInfo;
    }




}
