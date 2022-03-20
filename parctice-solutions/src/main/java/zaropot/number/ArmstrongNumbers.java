package zaropot.number;

public class ArmstrongNumbers {

    public boolean isArmstrongNumber(int number) {
        if(number < 0) {
            throw new IllegalArgumentException("Number can't be negative: " + number);
        }

        String[] numbersSplit = String.valueOf(number).split("");
        for(int i = 1; i <= numbersSplit.length; i++) {
            int sum = 0;
            sum = throughNumber(numbersSplit, i, sum);
            if(sum == number) {
                return true;
            }
        }
        return false;
    }


    private int throughNumber(String[] numbersSplit, int i, int sum) {
        for(int j = 0; j < numbersSplit.length; j++) {
            int num = Integer.parseInt(numbersSplit[j]);
            sum += Math.pow(num, i);
        }
        return sum;
    }

}
