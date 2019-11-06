package ink.lucien.demo.model;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Lucien on 2019/10/24 16:17
 */
@Service
public class Runner {

    private String pythonExecutor(String script, String args) throws IOException, InterruptedException {
        List<String> commandBuffer = new ArrayList<>();
        commandBuffer.add("python3");
        commandBuffer.add(script);
        commandBuffer.addAll(Arrays.asList(args.split(" ")));
        String[] command = new String[commandBuffer.size()];
        commandBuffer.toArray(command);
        Process process = Runtime.getRuntime().exec(command);
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        boolean flag = false;
        StringBuilder stringBuffer = new StringBuilder();
        while ((line = in.readLine()) != null) {
            if (flag) {
                stringBuffer.append(line).append("\n");
            }
            flag = true;
        }
        in.close();
        process.waitFor();
        return stringBuffer.toString();
    }

    public void run() {
        try {
            System.out.println(pythonExecutor("/Users/lucienshui/git/HelloJava/src/main/resources/main.py", "1 1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
