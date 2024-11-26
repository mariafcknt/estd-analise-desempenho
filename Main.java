public class Main {

    public static void main(String[] args) {
        
        // Mudar o tamanho do vetor aqui (10.000, 50.000 ou 100.000)
        int[] vetor = new int[50000];
        
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
            System.out.println(vetor[i]);
        }
        
        long inicio = System.currentTimeMillis();
        long fim;

        int aux;

        // Início do algoritmo do teste
        
        int n = vetor.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = vetor[i];
                int j = i;
                
                // Mover os elementos do vetor[0..i-gap] que são maiores que o temp
                while (j >= gap && vetor[j - gap] > temp) {
                    vetor[j] = vetor[j - gap];
                    j -= gap;
                }
                vetor[j] = temp;
            }
        }
        
        // Fim do algoritmo do teste
        
        System.out.println("Vetor ordenado");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }

        System.out.println();
        
        fim = System.currentTimeMillis();
        System.out.println("Tamanho do vetor: " + (vetor.length));
        System.out.println("Tempo em milisegundos: " + (fim - inicio));
    }
}
