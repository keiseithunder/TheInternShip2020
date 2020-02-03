import java.util.*;

public class Question1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
//        TreeMap<String, Integer> acronyms = new TreeMap<>();
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
//                System.out.println("bug");
                acronyms[currPosition++] = "  ";
            }
//            if (acronyms.get(acronym) == null) {
//                acronyms.put(acronym, 1);
//            } else {
//                acronyms.put(acronym, acronyms.get(acronym) + 1);
//            }
            else {
                acronyms[currPosition++] = acronym;

            }
        }
//        sc.close();
//        ArrayList<String[]> list = new ArrayList<>();
//        for (Map.Entry<String, Integer> entry : acronyms.entrySet()) {
//            if (list.size() < entry.getKey().length()) {
//                for (int i = list.size(); i < entry.getKey().length(); i++) {
//                    list.add(new String[n]);
//                }
//            }
//            for (int i = 0; i < entry.getValue(); i++) {
//                addToArray(entry.getKey(), list.get(entry.getKey().length() - 1));
//            }
//        }
        Arrays.sort(acronyms);
        Arrays.sort(acronyms, (s1, s2) -> s2.length() - s1.length());
        for (String s : acronyms
        ) {
            if (!s.equals("  ")) {
                System.out.println(s);
            }
        }
//        for (int i = list.size()-1; i >=0; i--) {
//            for (int j = 0; j < list.get(i).length; j++) {
//                if (list.get(i)[j] != null) {
//                    System.out.println(list.get(i)[j]+" ");
//                }
//            }
//        }
    }

}