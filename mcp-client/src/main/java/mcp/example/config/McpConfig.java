package mcp.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.client.transport.HttpClientSseClientTransport;
import io.modelcontextprotocol.json.jackson.JacksonMcpJsonMapper;
import io.modelcontextprotocol.spec.McpClientTransport;
import org.springframework.ai.mcp.client.common.autoconfigure.NamedClientMcpTransport;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Z.W.H
 * @version 1.0.0
 * @date2026/1/5 16:09
 * @description: MCPConfig
 */
@Configuration
public class McpConfig {


    /**
     * NamedClientMcpTransport这个类型的列表会在项目启动的时候在下面这个类中被处理
     * org.springframework.ai.mcp.client.common.autoconfigure.mcpSyncClients中被处理
     * yaml中配置实际上和创建的NamedClientMcpTransport对象是一致的，也是这个自动配置类中统一处理
     * 处理逻辑是
     * List<McpSyncClient> mcpSyncClients = new ArrayList<>();
     * 	List<NamedClientMcpTransport> namedTransports = transportsProvider.stream().flatMap(List::stream).toList();
     * 	然后循环这个List以后对于每一个NamedClientMcpTransport对象会封装成一个McpSyncClient对象
     * 	最终容器中会存在多个McpSyncClient对象
     * @return
     */
    @Bean
    public List<NamedClientMcpTransport> mcpClientTransport() {
        List<NamedClientMcpTransport> namedTransports = new ArrayList<>();
        McpClientTransport transport = HttpClientSseClientTransport
                .builder("https://mcp.amap.com")
                .sseEndpoint("/sse?key=aip_key")
                .jsonMapper(new JacksonMcpJsonMapper(new ObjectMapper()))
                .build();
        NamedClientMcpTransport amap = new NamedClientMcpTransport("amap", transport);

        namedTransports.add(amap);
        return namedTransports;
    }

    @Bean
    public String getMcpClientTransportName(ObjectProvider<List<McpSyncClient>> syncMcpClients) {

        List<McpSyncClient> mcpClients = syncMcpClients.stream().flatMap(List::stream).toList();

        return "amap";
    }

}