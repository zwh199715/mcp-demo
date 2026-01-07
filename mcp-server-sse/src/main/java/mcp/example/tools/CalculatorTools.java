package mcp.example.tools;

import org.springaicommunity.mcp.annotation.McpResource;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Z.W.H
 * @version 1.0.0
 * @date2025/12/9 16:52
 * @description: CalculatorTools
 */
@Component
public class CalculatorTools {

    private Map<String, String> configData = new HashMap<>(Map.of("key1", "value1", "key2", "value2"));


    @Tool(description = "Add two numbers together")
    public int addNumber(
            @McpToolParam(description = "First number", required = true) int a,
            @McpToolParam(description = "Second number", required = true) int b) {
        return a + b;
    }


    @Tool(description = "Get a configuration value")
    public String getConfig(String key) {
        return configData.get(key);
    }
}
