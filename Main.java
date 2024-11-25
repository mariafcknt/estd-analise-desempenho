public class Main {

    public static void main(String[] args) {

        int[] vetor = new int[100000];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
        }

        long inicio = System.currentTimeMillis();
        long fim;

        countingSort(vetor);

        fim = System.currentTimeMillis();
        System.out.println("Tamanho do vetor: " + vetor.length);
        System.out.println("Tempo em milisegundos: " + (fim - inicio));
    }

    public static void countingSort(int[] vetor) {
        int max = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > max) {
                max = vetor[i];
            }
        }

        int[] count = new int[max + 1];
        for (int i = 0; i < vetor.length; i++) {
            count[vetor[i]]++;
        }

        int k = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                vetor[k++] = i;
                count[i]--;
            }
        }
    }
}
