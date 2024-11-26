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

        
        int n = vetor.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(vetor, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            // Mover o maior elemento do heap para o final
            int temp = vetor[0];
            vetor[0] = vetor[i];
            vetor[i] = temp;

            // Chamar heapify no heap reduzido
            heapify(vetor, i, 0);
        }
        
        
        System.out.println("Vetor ordenado");
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }

        System.out.println();
        
        fim = System.currentTimeMillis();
        System.out.println("Tamanho do vetor: " + (vetor.length));
        System.out.println("Tempo em milisegundos: " + (fim - inicio));
    }

    public static void heapify(int[] vetor, int n, int i) {
        int largest = i; // Inicializar largest como raiz
        int left = 2 * i + 1; // Filho à esquerda
        int right = 2 * i + 2; // Filho à direita

        // Se o filho esquerdo for maior que a raiz
        if (left < n && vetor[left] > vetor[largest]) {
            largest = left;
        }

        // Se o filho direito for maior que o maior até agora
        if (right < n && vetor[right] > vetor[largest]) {
            largest = right;
        }

        // Se largest não for a raiz
        if (largest != i) {
            int swap = vetor[i];
            vetor[i] = vetor[largest];
            vetor[largest] = swap;

            // Recursivamente ajusta a árvore afetada
            heapify(vetor, n, largest);
        }
    }
}
