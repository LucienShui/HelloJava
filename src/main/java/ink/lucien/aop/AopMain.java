package ink.lucien.aop;

import ink.lucien.aop.annotation.Permission;

/**
 * Created by Lucien on 2019/10/21 12:31
 */
public class AopMain {

    @Permission
    private static String toUpper(String str) {
        return str.toUpperCase();
    }

    @Permission("Hello")
    private static String toLower(String str) {
        return str.toLowerCase();
    }

    public static void main(String[] args) {
        System.out.println(toUpper("Hello World!"));
        System.out.println(toLower("Hello World!"));
    }
}
