package mcp.example.controller;

import io.modelcontextprotocol.client.McpAsyncClient;
import io.modelcontextprotocol.client.McpSyncClient;
import io.modelcontextprotocol.spec.McpSchema;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.deepseek.DeepSeekChatModel;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Z.W.H
 * @version 1.0.0
 * @date2026/1/5 9:22
 * @description: McpExampleController
 */
@RestController
public class McpExampleController {


    private final DeepSeekChatModel chatModel;
    private final List<McpSyncClient> mcpSyncClients;
    private final ToolCallbackProvider toolCallbackProvider;




    @Autowired
    public McpExampleController(DeepSeekChatModel chatModel, List<McpSyncClient> mcpSyncClients, ToolCallbackProvider toolCallbackProvider) {
        this.chatModel = chatModel;
        this.mcpSyncClients = mcpSyncClients;
        this.toolCallbackProvider = toolCallbackProvider;

    }

    @GetMapping("/chat")
    public String chat(@RequestParam String question){
        return ChatClient.create(chatModel)
                .prompt(question)
                .toolCallbacks(toolCallbackProvider)
                .call()
                .content();
    }

    @GetMapping("/test")
    public void test(){
        McpSyncClient mcpSyncClient = mcpSyncClients.get(0);
        mcpSyncClient.listTools().tools().forEach(tool -> {
            System.out.println(tool.name());
        });

    }


}
