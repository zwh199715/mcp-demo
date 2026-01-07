package mcp.example.config;

import mcp.example.tools.CurrentTimeTools;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Z.W.H
 * @version 1.0.0
 * @date2026/1/5 9:58
 * @description: MCPServerConfig
 */
@Configuration
public class MCPServerConfig {

    @Bean
    public ToolCallbackProvider myTools(CurrentTimeTools tools) {

        return MethodToolCallbackProvider.builder().toolObjects(tools).build();

    }


}
