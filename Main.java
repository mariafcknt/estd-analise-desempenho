public class Main {

        public static void main(String[] args) {

            //Mudar o tamanho do vetor aqui (10.000, 50.000 ou 100.000)
            int[] vetor = new int[100000];
            
            for(int i = 0; i < vetor.length; i++){
                vetor[i] = (int) (Math.random() * vetor.length);
                System.out.println(vetor[i]);
            }
            
            long inicio = System.currentTimeMillis();
            long fim;
      
            int aux;

            //Início do algoritmo do teste
            
            int n = 1;
            boolean trocou = true;
            
            while (n <= vetor.length && trocou) {
                trocou = false; // Reinicia a flag para verificar se houve troca
                for (int i = 0; i < vetor.length - n; i++) {
                    if (vetor[i] < vetor[i + 1]) { // Alterado para ordenar de forma decrescente
                        aux = vetor[i];
                        vetor[i] = vetor[i + 1];
                        vetor[i + 1] = aux;
                        trocou = true; // Marca que houve troca
                    }
                }
                n++;
            }

            //Fim do algoritmo do teste
            
            System.out.println("Vetor ordenado");
            for(int i = 0; i < vetor.length; i++){
                System.out.println(vetor[i]);
            }

            System.out.println();
            
            fim = System.currentTimeMillis();
            System.out.println("Tamanho do vetor: " + (vetor.length));
            System.out.println("Tempo em milisegundos: " + (fim-inicio));
        }
    }
