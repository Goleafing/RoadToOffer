public class TestJava{
    public static void main(String[] args) {
        TestJava testJava = new TestJava();
        testJava.xingqi();
        testJava.testFor();
        testJava.testForNum();
    }

    public void xingqi(){
        int i = 1;
        switch (i) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
    
            default:
                System.out.println("不知道");
                break;
        }
    }

    private void testFor() {
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 3; j++) {
                System.out.println(i*j);
            }
        }
    }

    private void testForMul() {
        for(int i = 1; i <= 9; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(i*j);
            }
            System.out.println();
        }
    }

    private void testForNum() {
        for(int i = 1; i <= 100; i++) {
            int cishu = 0;
            for (int j = 1; j <= i; j++) {
                if(i % j == 0) {
                    cishu++;
                }
            }
            if(cishu == 2)  {
                System.out.print(i+" ");
            }
        }
    }
    
}
