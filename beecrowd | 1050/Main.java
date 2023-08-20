import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


 
/**
 * IMPORTANT: 
 *      O nome da classe deve ser "Main" para que a sua solução execute
 *      Class name must be "Main" for your solution to execute
 *      El nombre de la clase debe ser "Main" para que su solución ejecutar
 */
public class Main {
 
    public static void main(String[] args) throws IOException {
        Map<Integer, String> ddd = new HashMap<Integer, String>();
        ddd.put(61, "Brasilia");
        ddd.put(71, "Salvador");
        ddd.put(11, "Sao Paulo");
        ddd.put(21, "Rio de Janeiro");
        ddd.put(32, "Juiz de Fora");
        ddd.put(19, "Campinas");
        ddd.put(27, "Vitoria");
        ddd.put(31, "Belo Horizonte");

        Scanner input = new Scanner(System.in); 

        String entrada = input.nextLine();
        int value = Integer.parseInt(entrada);
        if(ddd.containsKey(value)){
          System.out.println(ddd.get(value));
        }else{
          System.out.println("DDD nao cadastrado");  
        }
        
        ddd.clear();
    }
 
}