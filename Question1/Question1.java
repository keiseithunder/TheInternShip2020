import java.util.*;

public class Question1 {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n = Integer.parseInt(sc.nextLine());
  String[] acronyms = new String[n];
  int currPosition = 0;
  for (int i = 0; i < n; i++) {
   String word = sc.nextLine();
   String acronym = "";
   if (word.length() != 0 && Character.isUpperCase(word.charAt(0))) {
    acronym += word.charAt(0);
   }
   for (int j = 0; j < word.length(); j++) {
    if (word.charAt(j) == ' ' && j + 1 < word.length() && word.charAt(j + 1) != ' ') {
     if (Character.isUpperCase(word.charAt(j + 1))) {
      acronym += word.charAt(j + 1);
     }
     j++;
    }
   }
   if (acronym.equals("")) {
    acronyms[currPosition++] = "  ";
   } else {
    acronyms[currPosition++] = acronym;
   }
  }
  sc.close();

  Arrays.sort(acronyms, (s1, s2) -> {
   if (s2.length() - s1.length() == 0) {
    return s1.compareTo(s2);
   }
   return s2.length() - s1.length();

  });
  for (String s : acronyms) {
   if (!s.equals("  ")) {
    System.out.println(s);
   }
  }
 }

}