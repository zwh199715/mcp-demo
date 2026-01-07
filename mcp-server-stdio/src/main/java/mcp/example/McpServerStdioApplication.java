package mcp.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Slf4j
public class McpServerStdioApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(McpServerStdioApplication.class, args);
        log.info("McpServerStdioApplication started");
    }
}
