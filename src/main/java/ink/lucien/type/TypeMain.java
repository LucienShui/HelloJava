package ink.lucien.type;

public class TypeMain {
    public static void main(String[] args) {
        System.out.println(Long.parseLong("123456"));
        try {
            System.out.println(Long.parseLong("1234a6"));
        } catch (Exception e) {
            System.out.println("Number format error");
        }
    }
}
