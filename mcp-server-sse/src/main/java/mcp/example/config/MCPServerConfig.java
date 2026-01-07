package mcp.example.config;

import mcp.example.tools.CalculatorTools;
import mcp.example.tools.FileReadTools;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author Z.W.H
 * @version 1.0.0
 * @date2026/1/5 9:34
 * @description: MCPServerConfig
 */
@Configuration
public class MCPServerConfig {

    @Bean
    public ToolCallbackProvider myTools(CalculatorTools calculatorTools, FileReadTools fileReadTools) {
        return MethodToolCallbackProvider.builder().toolObjects(calculatorTools,fileReadTools).build();
    }


}
