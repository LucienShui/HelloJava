package ink.lucien.demo.main;

import ink.lucien.demo.model.Runner;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

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
}
