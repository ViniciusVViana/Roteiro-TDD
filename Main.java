abstract class Money{
    protected int amount;
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount && getClass().equals(money.getClass());
    }
    static Money dollar(int amount){
        return new Dollar(amount);
    }
    static Money franc(int amount){
        return new Franc(amount);
    }
    abstract Money times(int multiplier);
    public int getAmount(){
        return amount;
    }
}

class Dollar extends Money{
    Dollar(int amount){
        this.amount = amount;
    }
    Money times(int multiplier){
        return new Dollar(amount * multiplier);
    }
}

class Franc extends Money{
    private int amount;
    Franc(int amount){
        this.amount = amount;
    }
    Money times(int multiplier){
        return new Franc(amount * multiplier);
    }
}

class Test{
    public void assertEquals(Money a, Money b){
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
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
     }
     public void testEquality() {
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
     }

     public void testFrancMultiplication() {
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
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
