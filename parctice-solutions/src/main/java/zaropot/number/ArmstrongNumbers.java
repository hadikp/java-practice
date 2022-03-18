package zaropot.number;

public class ArmstrongNumbers {


    public boolean isArmstrongNumber(int number) {
        if(number < 0) {
            throw new IllegalArgumentException("Number can't be negative: " + number);
        }
        int sum = 0;
        String[] numbersSplit = String.valueOf(number).split("");
        for(int i = 0; i < 4; i++) {
                for(int j = 0; j < numbersSplit.length; j++) {
                    int num = Integer.parseInt(numbersSplit[j]);
                    sum += Math.pow(num, i);
                }
            if(sum == number) {
                return true;
            }
        }
        return false;
    }
}
