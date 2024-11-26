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
        
        for (int i = 1; i < vetor.length; i++) {
            int key = vetor[i];  
            int j = i - 1;
            
           
            while (j >= 0 && vetor[j] > key) {
                vetor[j + 1] = vetor[j];
                j = j - 1;
            }

            vetor[j + 1] = key;
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
