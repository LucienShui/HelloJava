package ink.lucien.demo.model;

import lombok.Getter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Lucien on 2019/11/13 10:47
 */
public class PythonExecutor {

    @Getter
    private String scriptPath;

    @Getter
    private String pyVersion;

    public PythonExecutor(String scriptPath) {
        this.scriptPath = scriptPath;
        this.pyVersion = "python3";
    }

    public PythonExecutor(String scriptPath, String pyVersion) {
        this.scriptPath = scriptPath;
        this.pyVersion = pyVersion.toLowerCase();
    }

    public String run() throws IOException, InterruptedException {
        return execute(this.scriptPath);
    }

    public String run(Object... args) throws IOException, InterruptedException {
        return execute(this.scriptPath, args);
    }

    private String execute(String scriptPath, Object... args) throws IOException, InterruptedException {
        List<String> commandBuffer = new ArrayList<>();
        commandBuffer.add(pyVersion);
        commandBuffer.add(scriptPath);
        commandBuffer.addAll(Arrays.stream(args).map(Object::toString).collect(Collectors.toList()));
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
}
