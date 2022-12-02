import java.util.*;

public class ValidParentheses {

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        boolean caracter = ehValido(scanner.nextLine());

        System.out.println(caracter);
    }

    public static boolean ehValido(String s) {
    int ParenOpen = 0, ParenClose = 0;
    int ColOpen = 0, ColClose = 0;
    int ChavOpen = 0, ChavClose = 0;
    
    for (int i =0; i < s.length(); i ++) {
      if (s.charAt(i) == '(') ParenOpen ++;
      if (s.charAt(i) == ')') ParenClose ++;
      if (s.charAt(i) == '[') ColOpen ++;
      if (s.charAt(i) == ']') ColClose ++;
      if (s.charAt(i) == '{') ChavOpen ++;
      if (s.charAt(i) == '}') ChavClose ++;
    } 
      int sumParen = ParenOpen - ParenClose;
      int sumCol = ColOpen - ColClose;
      int sumChav = ChavOpen - ChavClose;
      
      if (sumParen == 0 && sumCol == 0 && sumChav == 0) {
      return true;
      } else {
        return false;
      }
    }
}