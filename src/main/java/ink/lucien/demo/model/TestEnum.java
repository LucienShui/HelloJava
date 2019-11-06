package ink.lucien.demo.model;

import lombok.Getter;

/**
 * Created by Lucien on 2019/11/06 11:56
 */
@Getter
public enum TestEnum {

    ONE("one"), TWO("%s");

    private String message;

    TestEnum(String message) {
        this.message = message;
    }

    public TestEnum fillArgs(Object... args) {
        this.message = String.format(this.message, args);
        return this;
    }
}
