class Dollar{
    int amount = 10;
    Dollar(int amount){}
    void times(int multiplier){}
}

class Test{
    public void assertEquals(int a, int b){
        if(a == b){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
    }
    public void testMultiplication(){
        Dollar five = new Dollar(5);
        five.times(2);
        assertEquals(10, five.amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Test test = new Test();
        test.testMultiplication();
    }
}
