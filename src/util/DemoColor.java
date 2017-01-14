
package util;


    public class DemoColor {

    public static void main(String[] args) {
        
        System.out.println(RpgUtil.ANSI_BG_YELLOW+ RpgUtil.ANSI_BLUE+"Hello World\n");
        
        for (int i = 41; i <= 47; i++) {
            for (int j = 31; j < 37; j++) {
                System.out.println("\u001B[" + i + "m" + "\u001B[" + j + "m" + "Hello World BG:" + i + " FG:" + j);
            }
        }
    }
}


