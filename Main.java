public class Main {

    public static void main(String[] args) {

        int[] vetor = new int[50000];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
        }

        long inicio = System.currentTimeMillis();
        long fim;

        mergeSort(vetor);

        fim = System.currentTimeMillis();
        System.out.println("Tamanho do vetor: " + vetor.length);
        System.out.println("Tempo em milisegundos: " + (fim - inicio));
    }

    public static void mergeSort(int[] vetor) {
        if (vetor.length <= 1) return;

        int meio = vetor.length / 2;
        int[] left = new int[meio];
        int[] right = new int[vetor.length - meio];

        System.arraycopy(vetor, 0, left, 0, meio);
        System.arraycopy(vetor, meio, right, 0, vetor.length - meio);

        mergeSort(left);
        mergeSort(right);

        merge(vetor, left, right);
    }

    public static void merge(int[] vetor, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                vetor[k++] = left[i++];
            } else {
                vetor[k++] = right[j++];
            }
        }
        while (i < left.length) {
            vetor[k++] = left[i++];
        }
        while (j < right.length) {
            vetor[k++] = right[j++];
        }
    }
}
