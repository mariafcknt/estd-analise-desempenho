
public class bubble {

        public static void main(String[] args) {
            int[] vetor = new int[100];
            
            for(int i = 0; i < vetor.length; i++){
                vetor[i] = (int) (Math.random() * vetor.length);
                System.out.println(vetor[i]);
            }
            
            long inicio = System.currentTimeMillis();
            long fim;
      
            int aux;
            //BUBBLE SORT Original
            
            for(int i = 0; i < vetor.length; i++){ 
                for(int j = 0; j < vetor.length - 1 ; j++){ 
                    if (vetor[j] > vetor[j+1]){
                        aux = vetor[j];
                        vetor[j] = vetor[j+1];
                        vetor[j+1] = aux;
                    }
                }
            }
            
            fim = System.currentTimeMillis();
            System.out.println("Tempo em milisegundos: " + (fim-inicio));
            
           
            System.out.println("Vetor ordenado");
            for(int i = 0; i < vetor.length; i++){
                System.out.println(vetor[i]);
            }
            
        }
    }
