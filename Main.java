public class Main {

    public static void main(String[] args) {

        // Mudar o tamanho do vetor aqui (10.000, 50.000 ou 100.000)
        int[] vetor = new int[10000];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
            System.out.println(vetor[i]);
        }

        long inicio = System.currentTimeMillis();
        long fim;

        // Início do algoritmo do teste
        quickSort(vetor, 0, vetor.length - 1);
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

    // Implementação do Quick Sort
    public static void quickSort(int[] vetor, int p, int r) {
        if (p < r) {
            int q = particao(vetor, p, r);
            quickSort(vetor, p, q - 1);
            quickSort(vetor, q + 1, r);
        }
    }

    // Função de partição
    public static int particao(int[] vetor, int p, int r) {
        int x = vetor[p];
        int up = r;
        int down = p;

        while (down < up) {
            while (vetor[down] <= x && down < r) {
                down++;
            }
            while (vetor[up] > x) {
                up--;
            }
            if (down < up) {
                troca(vetor, down, up);
            }
        }

        vetor[p] = vetor[up];
        vetor[up] = x;
        return up;
    }

    // Função para trocar elementos
    public static void troca(int[] vetor, int i, int j) {
        int temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }
}
