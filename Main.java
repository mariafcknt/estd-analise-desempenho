import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] vetor = new int[50000];

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
        }

        long inicio = System.currentTimeMillis();
        long fim;

        bucketSort(vetor);

        fim = System.currentTimeMillis();
        System.out.println("Tamanho do vetor: " + vetor.length);
        System.out.println("Tempo em milisegundos: " + (fim - inicio));
    }

    public static void bucketSort(int[] vetor) {
        int n = vetor.length;
        if (n <= 0) return;

        int minValue = vetor[0];
        int maxValue = vetor[0];
        for (int i = 1; i < n; i++) {
            if (vetor[i] < minValue) minValue = vetor[i];
            if (vetor[i] > maxValue) maxValue = vetor[i];
        }

        int bucketCount = (maxValue - minValue) / n + 1;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int index = (vetor[i] - minValue) / n;
            buckets.get(index).add(vetor[i]);
        }

        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }

        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int value : bucket) {
                vetor[index++] = value;
            }
        }
    }
}