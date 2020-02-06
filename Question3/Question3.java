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
   int input = getInt(sc);
   if (input != 99) {
    hangman[i] = input;
   } else {
    i--;
    continue;
   }
  }
  System.out.println("_ _ _ _ _ _ _ _ _ _ _ _");
  for (int i = 0; i < 5; i++) {
   int guess = getInt(sc);
   if(guess!=99){
    checkAns(guess);
    printAfterGuess();
   }else{
    i--;
    continue;
   }
  }
  System.out.println(point);
 }

 static void checkAns(int x) {
  // System.out.println(x);
  boolean isCorrect = false;
  for (int i = 0; i < 12; i++) {
   if (hangman[i] == x) {
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
    printString = printString + (i + 1 == 12 && curWrong == 0 ? "_" : "_ ");
   }
  }
  for (int i = 0; i < curWrong; i++) {
   printString = printString + wrongGuess[i] + (i + 1 == curWrong ? "" : " ");
  }
  System.out.println(printString);
 }

 static int getInt(Scanner sc) {
  try {
   String input = sc.next();
   int parsed = Integer.parseInt(input);
   if (parsed < 10 && parsed >= 0) {
    return parsed;
   }
  } catch (Exception e) {
   // TODO: handle exception
  }
  System.out.println("Please input number between 0-9");
  return 99;
 }
}
