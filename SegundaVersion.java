/**
 *
 * @author Alex
 */

import java.util.Collections;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class SegundaVersion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int casos = sc.nextInt();
        int veces = 0;
        Integer numero;
        while (casos != 0) {
            HashMap<Integer, Integer> numeros = new HashMap<>();
            for (int i = 0; i < casos; i++) {
                numero = Integer.parseInt(sc.next());
                if (numeros.get(numero) == null) {
                    veces = 1;
                } else {
                    veces = numeros.get(numero) + 1;
                }

                numeros.put(numero, veces);

            }
            Object maxEntry = Collections.max(numeros.entrySet(), Map.Entry.comparingByValue()).getKey();

            System.out.println(maxEntry);
            casos = sc.nextInt();
        }

    }

}
