package mcp.example.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileReader;

/**
 * @author Z.W.H
 * @version 1.0.0
 * @date2026/1/6 14:59
 * @description: FileReadTools
 */
@Component
public class FileReadTools {

    @Tool(description = "获取到项目周报的原始数据")
    public String readFile() {
        // 模拟从文件中读取数据
        String filePath = "D:\\work\\doc\\POJ_大模型管理平台\\SPOJ_闲聊智能体\\项目周报.txt";
        try {
            // 创建一个File对象，并指定文件路径
            File file = new File(filePath);

            // 创建一个FileReader对象，用于读取文件
            FileReader reader = new FileReader(file);

            // 创建一个字符数组，用于存储文件内容
            char[] chars = new char[(int) file.length()];

            // 使用read方法将文件内容读取到字符数组中
            reader.read(chars);

            // 关闭FileReader对象
            reader.close();

            // 返回文件内容
            return new String(chars);
         } catch (Exception e) {
            return "File Read fail!";
        }

    }

}
