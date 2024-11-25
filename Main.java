public class Main {

    public static void main(String[] args) {

        int[] vetor = new int[100000];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
        }

        long inicio = System.currentTimeMillis();
        long fim;

        radixSort(vetor);

        fim = System.currentTimeMillis();
        System.out.println("Tamanho do vetor: " + vetor.length);
        System.out.println("Tempo em milisegundos: " + (fim - inicio));
    }

    public static void radixSort(int[] vetor) {
        int max = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > max) {
                max = vetor[i];
            }
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(vetor, exp);
        }
    }

    public static void countingSort(int[] vetor, int exp) {
        int[] output = new int[vetor.length];
        int[] count = new int[10];

        for (int i = 0; i < vetor.length; i++) {
            count[(vetor[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = vetor.length - 1; i >= 0; i--) {
            output[count[(vetor[i] / exp) % 10] - 1] = vetor[i];
            count[(vetor[i] / exp) % 10]--;
        }

        System.arraycopy(output, 0, vetor, 0, vetor.length);
    }
}
