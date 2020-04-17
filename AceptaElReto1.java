/**
 *
 * @author Alex
 */
import java.util.*;

public class AceptaElReto1 {

    public static void main(String[] args) {
        List<Categoria> categorias = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while(true){
            String categoria = sc.nextLine();
            if (categoria.equalsIgnoreCase("FIN")) {
                break;
            }
            Categoria cat = new Categoria();
            cat.generarPartidos(sc);
            categorias.add(cat);

        }

        for(Categoria categoria: categorias){
            categoria.imprimirCampeon();
        }

    }

}
class Categoria{

        HashMap<String, Puntuacion> equipos;
        int partidosJugados;

        public Categoria(){
            equipos = new HashMap<>();
            partidosJugados = 0;
        }

        public void generarPartidos(Scanner sc){
          while(true){
              //Scanner sc = new Scanner(System.in);
              String linea = sc.nextLine();

              if(linea.equalsIgnoreCase("FIN")){
                break;
              }

              String[] partes = linea.split(" ");
              String equipo1 = partes[0], equipo2 = partes[2];
              int puntos1=Integer.parseInt(partes[1]),puntos2=Integer.parseInt(partes[3]);

              if (puntos1 > puntos2) {
                  victoriaA(equipo1, equipo2);
              }else{
                  victoriaA(equipo2, equipo1);
              }
          }
        }

        public void victoriaA(String ganador, String perdedor){
            añadir(ganador); añadir(perdedor);
            añadirPuntos(ganador, 2);
            añadirPuntos(perdedor, 1);
            partidosJugados++;
        }

        private void añadir(String equipo){
            if(!equipos.containsKey(equipo))
                equipos.put(equipo, new Puntuacion());
        }

        private void añadirPuntos(String equipo, int puntos){
            equipos.get(equipo).aumentar(puntos);
        }

        public void imprimirCampeon(){
            String aux = "";
            Integer puntos = 0;
            boolean empate = false;
            for(HashMap.Entry<String, Puntuacion> equipo: equipos.entrySet()){
                int puntosEquipo = equipo.getValue().getPuntos();
                if(puntosEquipo > puntos){
                    aux = equipo.getKey();
                    empate = false;
                    puntos = puntosEquipo;
                }
                else if(puntosEquipo == puntos){
                    empate = true;
                    aux = "EMPATE";
                }
            }

            System.out.println(aux + " " + partidosRestantes());
        }

        public int partidosRestantes(){
            int aux = (2*equipos.size() -2 )* (equipos.size() / 2);
            return (aux - partidosJugados);
        }

    }

    class Puntuacion{
        private int puntos;
        public Puntuacion(){
            this.puntos = 0;
        }

        public void aumentar(int puntos){
            if(puntos == 1 || puntos == 2)
                this.puntos += puntos;
        }

        public int getPuntos(){
            return puntos;
        }
    }
