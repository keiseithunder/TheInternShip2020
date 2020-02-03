import java.util.Scanner;


public class Question2 {

    static int MAX_NUMBER = 10999;
    static boolean primeNum[] = new boolean[MAX_NUMBER + 1];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        generateSieve();
        String number = sc.nextLine();
        while (!number.equals("0.0")) {
            //if the input n < 1.0 || n > 10.0
            if(isNotValid(number)){
                if (number.length()==0){
                    number = sc.nextLine();
                    continue;
                }
                System.out.println(false);
                number=sc.nextLine();
                continue;
            }
            int index = number.indexOf(".");
            if (index == -1) {
                index = number.length();
            }
            boolean test = false;
            String currentNum = number.substring(0, index);
            for (int j = index + 1; j <= index + 3 && !test; j++) {
                currentNum += number.charAt(j);
                test = primeNum[Integer.parseInt(currentNum)];
            }
            System.out.println(test);
            number = sc.nextLine();
        }
    }

    static void generateSieve() {
        for (int i = 0; i < MAX_NUMBER; i++)
            primeNum[i] = true;
        for (int num = 2; num * num <= MAX_NUMBER; num++) {
            if (primeNum[num] == true) {
                for (int i = num * num; i <= MAX_NUMBER; i += num)
                    primeNum[i] = false;
            }
        }
    }

    static boolean isNotValid(String s){
        if(s.length()==0||Double.parseDouble(s)>10.00 || Double.parseDouble(s)<1.000){
            return true;
        }
        return false;
    }
}
