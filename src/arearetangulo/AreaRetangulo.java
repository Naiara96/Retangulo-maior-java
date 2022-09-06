/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/*Dada uma matriz binária 2D de tamanho MxN preenchida com '0' (zero) e '1' (um), encontre o retângulo de 
maior área contendo apenas '1' e retorne o valor de sua área

Exemplo:

Entrada:

[

  ['1','0','1','0','0'],

  ['1','0','1','1','1'],

  ['1','1','1','1','1'],

  ['1','0','0','1','0']

]*/

package arearetangulo;

/**
 *
 * @author Naiara dos Santos Silva
 */
public class AreaRetangulo {
    public static void main(String[] args){
        int[][] matriz = {{ 1, 0, 1 , 0 , 0 },{ 1, 0, 1 , 1, 1},{ 1 , 1 , 1 , 1 , 1},{ 1, 0, 0, 1, 0 }

        };
    
        System.out.println( " A maior area de retangulo formado na matriz e "
                + areaMaior(matriz));
    }
    /**
     * Após a inicialização e o tipo da variável da matriz de entrada declada, o seguinte método faz uma varredura e
    verifica quais elementos da tabela estão completados com zero, os que tiverem terão seu valor substituído por 'um'.
     * @param matriz
    */
    public static void formaRetangulo(int[][] matriz)
    {
        for (int[] retangulo : matriz) {
            for (int l = 0; l < matriz[0].length; l++) {
                if (retangulo[l] == 0) {
                    retangulo[l] = 1;
                }
            }
        }
    }
 
    /**
     * o método vai calcular a área do maior retângulo formado por números 1's; as colunas serão invertidas e será 
    carregada a matriz com os números 'uns' sucessivos,  realizando o processamento dos dados da coluna de baixo para cima.
     * @param matriz
     * @return 
    */
    
     public static int areaMaior(int[][] matriz)
    {
       
        int M = matriz.length;
        int N = matriz[0].length;
 
        
        for (int c = 0; c < N; c++)
        {
            
            for (int l = M - 2; l >= 0; l--)
            {
                if (matriz[l][c] == 1) {
                    matriz[l][c] = matriz[l+1][c] + 1;
                }
            }
        }
        
    /**
    A áreaMaior vai monitorar o maior retangulo encontrado até agora; um laço vai percorrer cada linha da matriz formada em busca do maior valor, 
    o vetor contador receberá o maior valor de cada linha para processá-la em outro laço e incrementar no contador. A área maior vai receber o valor 
    máximo dos elementos do contador multiplicados pelos elementos da matriz. Esse valor vai ser retornado e exibido na tela.
        */
    
        int areaMaior = 0;
 
        
        for (int l = 0; l < M; l++)
        {

            int[] contador = new int[M + 1];
 
            
            for (int c = 0; c < N; c++)
            {
                if (matriz[l][c] > 0)
                {
                   
                    contador[matriz[l][c]] += 1;
                    
                    areaMaior = Integer.max(areaMaior, matriz[l][c] * contador[matriz[l][c]]);
                }
            }
        }
 
        return areaMaior;
    }
     
}