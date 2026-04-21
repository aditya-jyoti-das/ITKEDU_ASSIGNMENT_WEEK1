package assignment_1;

public class Main {

    private static CustomStringBuilder
            customStringBuilder;


    public static void main(String[] args) {
        customStringBuilder = new CustomStringBuilder();

        customStringBuilder.append("save");
        customStringBuilder.append("tree");
        customStringBuilder.delete(0, customStringBuilder.toString().length());
        customStringBuilder.append("!");
        System.out.println("current-value:--" + customStringBuilder.toString());
        customStringBuilder.undo();
        System.out.println("after-undo:--   " + customStringBuilder.toString());
        customStringBuilder.undo();
        System.out.println("after-undo:--   " + customStringBuilder.toString());
        customStringBuilder.undo();
        System.out.println("after-undo:--   " + customStringBuilder.toString());

    }
}