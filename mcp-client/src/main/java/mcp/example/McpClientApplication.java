package mcp.example;

import io.modelcontextprotocol.client.McpClient;
import io.modelcontextprotocol.client.McpSyncClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.mcp.client.common.autoconfigure.McpClientAutoConfiguration;
import org.springframework.ai.mcp.client.common.autoconfigure.NamedClientMcpTransport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
@Slf4j
@SpringBootApplication
public class McpClientApplication
{
    public static void main( String[] args )
    {
        ApplicationContext context = SpringApplication.run(McpClientApplication.class, args);
        String[] beanNamesForType = context.getBeanNamesForType(List.class);
        for (String beanName : beanNamesForType){
            log.info("beanName: {}", beanName);
        }

        Object mcpClientTransport = context.getBean("mcpClientTransport");
        Object stdioTransports = context.getBean("stdioTransports");
        Object sseHttpClientTransports = context.getBean("sseHttpClientTransports");
        Object streamableHttpHttpClientTransports = context.getBean("streamableHttpHttpClientTransports");
        Object mcpSyncClients = context.getBean("mcpSyncClients");
        log.info("McpClientApplication start success!");
    }
}
