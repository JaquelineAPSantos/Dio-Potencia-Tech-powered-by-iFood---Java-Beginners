import java.util.*;

public class ChecagemDePalindromo {
  public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String palavra = sc.nextLine();
        sc.close();
        String palindromo = "";
        
        for (int i = palavra.length() -1; i >= 0; i--) {
          palindromo += palavra.charAt(i);
        }
        if (palindromo.equals(palavra)) {
          System.out.print("TRUE");
        } else {
          System.out.print("FALSE");
        }
    }
}