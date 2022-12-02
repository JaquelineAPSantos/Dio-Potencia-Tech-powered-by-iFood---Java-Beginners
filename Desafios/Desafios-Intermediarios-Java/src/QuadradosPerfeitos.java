import java.util.*;

public class QuadradosPerfeitos {

    public static void main(String[] args) {
        int n = Integer.parseInt(new Scanner(System.in).nextLine());

        int[] d = new int[n + 1];
        
        List<Integer> lista = listarQuadradosPerfeitos(n);
        int menorNumero = iterar(lista, n);
        System.out.println(menorNumero);

    }
    
    public static int iterar(List<Integer> lista, int n){
        boolean resultado = false;
        int iteracoes = 0;
        while(!resultado) {
            iteracoes++;
            if (lista.contains(n / iteracoes )) {
                resultado = true;
            } else if (somarQuadradosPerfeitos(lista, n, iteracoes)) {
                iteracoes++;
                resultado = true;
            }
        }
        return iteracoes;
    }
    
    public static boolean somarQuadradosPerfeitos(List<Integer> lista, int n, int iteracao){
        boolean resultado = false;
        int maiorIndice = lista.size() - 1;
        int acumulado = lista.get(maiorIndice);
        while(iteracao > 0){
            for(int i = maiorIndice; i >= 0; i--){
                if(acumulado + lista.get(i) == n){
                    i = 0;
                    iteracao = 0;
                    resultado = true;
                } else if(acumulado + lista.get(i) < n){
                    acumulado = acumulado + lista.get(i);
                }
            }
            iteracao--;
        }
        return resultado;
    }

    public static List<Integer> listarQuadradosPerfeitos(int n){
        int numero = 1;
        int quadradoPerfeito = 1;
        List<Integer> lista = new ArrayList<>();
        while( n >= quadradoPerfeito ){
            lista.add(quadradoPerfeito);
            numero++;
            quadradoPerfeito = numero * numero;
        };
        return lista;
    }
}
