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

            //Início so algoritmo do teste
            
            for(int i = 0; i < vetor.length; i++){ 
                for(int j = 0; j < vetor.length - 1 ; j++){ 
                    if (vetor[j] > vetor[j+1]){
                        aux = vetor[j];
                        vetor[j] = vetor[j+1];
                        vetor[j+1] = aux;
                    }
                }
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
