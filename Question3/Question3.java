import java.util.Scanner;

public class Question3 {
    static int[] wrongGuess = new int[5];
    static int curWrong = 0;
    static int[] hangman = new int[12];
    static boolean[] correctness = new boolean[12];
    static int point = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 12; i++) {
            hangman[i] = sc.nextInt();
        }
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _");
        for (int i = 0; i < 5; i++) {
            int guess = sc.nextInt();
            checkAns(guess);
            printAfterGuess();
        }
        System.out.println(point);
    }

    static void checkAns(int x) {
//        System.out.println(x);
        boolean isCorrect = false;
        for (int i = 0; i < 12; i++) {
            if (hangman[i] == x) {
//                System.out.println(true);
                correctness[i] = true;
                isCorrect = true;
                point++;
            }
        }
        if (!isCorrect) {
            wrongGuess[curWrong] = x;
            curWrong++;
        }
    }

    static void printAfterGuess() {
        String printString = "";
        for (int i = 0; i < 12; i++) {
            if (correctness[i] == true) {
                printString = printString + hangman[i] + (i + 1 == 12 && curWrong == 0 ? "" : " ");
            } else {
                printString = printString +(i + 1 == 12 && curWrong == 0 ? "_" : "_ ") ;
            }
        }
        for (int i = 0; i < curWrong; i++) {
            printString = printString + wrongGuess[i] + (i + 1 == curWrong ? "" : " ");
        }
        System.out.println(printString);
    }
}
