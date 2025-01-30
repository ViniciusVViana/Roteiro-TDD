class Money{
    protected int amount;
    protected String currency;
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount && currency().equals(money.currency());
     }
    static Money dollar(int amount){
        return new Money(amount, "USD");
    }
    static Money franc(int amount){
        return new Money(amount, "CHF");
    }
    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
     }
    Money times(int multiplier) {
        return new Money(amount * multiplier, currency);
     }
    public int getAmount(){
        return amount;
    }
    String currency(){
        return currency;
    };
}

class Test{
    public void assertEquals(Money a, Money b){
        if(a.getAmount() == b.getAmount()){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
    }
    public void assertEquals(String a, String b){
        if(a == b){
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
        assertFalse(Money.franc(5).equals(Money.dollar(5)));
     }	
     public void testCurrency(){
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
     }
}

public class Main {
    public static void main(String[] args) {
        Test test = new Test();
        test.testMultiplication();
        test.testEquality();
    }
}
