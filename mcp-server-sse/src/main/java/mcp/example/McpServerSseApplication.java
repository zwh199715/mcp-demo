package mcp.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@Slf4j
@SpringBootApplication
public class McpServerSseApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(McpServerSseApplication.class, args);
        log.info("McpServerSseApplication started");
    }
}
