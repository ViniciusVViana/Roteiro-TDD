class Money{
    protected int amount;
    public boolean equals(Object object){
        Money money = (Money) object;
        return amount == money.amount;
    }
}

class Dollar extends Money{
    Dollar(int amount){
        this.amount = amount;
    }
    Dollar times(int multiplier){
        return new Dollar(amount * multiplier);
    }
    public int getAmount(){
        return amount;
    }
}

class Franc extends Money{
    private int amount;
    Franc(int amount){
        this.amount = amount;
    }
    Franc times(int multiplier){
        return new Franc(amount * multiplier);
    }
    public int getAmount(){
        return amount;
    }
}

class Test{
    public void assertEquals(Dollar a, Dollar b){
        if(a.getAmount() == b.getAmount()){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
    }
    public void assertEquals(Franc a, Franc b){
        if(a.getAmount() == b.getAmount()){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
    }
    public void assertTrue(boolean a){
        if(a){
            System.out.println("Test True");
        }else{
            System.out.println("Test not True");
        }
    }
    public void assertFalse(boolean a){
        if(!a){
            System.out.println("Test False");
        }else{
            System.out.println("Test not False");
        }
    }
    public void testMultiplication(){
        Dollar five = new Dollar(5);
        assertEquals(new Dollar(10), five.times(2));
        assertEquals(new Dollar(15), five.times(3));
    }
    public void testEquality() {
        assertTrue(new Dollar(5).equals(new Dollar(5)));
        assertFalse(new Dollar(5).equals(new Dollar(6)));
        assertTrue(new Franc(5).equals(new Franc(5)));
        assertFalse(new Franc(5).equals(new Franc(6)));
     }

    public void testFrancMultiplication(){
        Franc five = new Franc(5);
        assertEquals(new Franc(10), five.times(2));
        assertEquals(new Franc(15), five.times(3));
    }
}

public class Main {
    public static void main(String[] args) {
        Test test = new Test();
        test.testMultiplication();
        test.testEquality();
        test.testFrancMultiplication();
    }
}
