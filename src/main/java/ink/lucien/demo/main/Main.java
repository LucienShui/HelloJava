package ink.lucien.demo.main;

import ink.lucien.demo.model.PythonExecutor;
import ink.lucien.demo.model.Runner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Lucien on 2019/10/24 14:54
 */
@Slf4j
@Service
public class Main {

    private final Runner runner;

    public Main(Runner runner) {
        this.runner = runner;
    }

    public void main() {
        runner.run();
    }

    private void testPythonExecutor() {
        try {
            PythonExecutor pythonExecutor = new PythonExecutor("py/main.py");
            System.out.println(pythonExecutor.run(1, 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
