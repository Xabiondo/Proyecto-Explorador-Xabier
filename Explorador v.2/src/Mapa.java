import java.util.Scanner;

public class Mapa {
    public char tablero[][];
    private Posicion posTesoro;
    private Posicion posJugador;
    private Enemigo Enemigo1;
    private Enemigo Enemigo2;
    private Enemigo Enemigo3;
    private Posicion posicionTrampas;

    public Mapa(){
        this.tablero = new char[6][20];
        this.posTesoro = new Posicion((int)(Math.random()*6) ,(int)(Math.random()*20));
        situarTesoro();

        this.Enemigo1  = new Enemigo();
        this.Enemigo2  = new Enemigo();
        this.Enemigo3  = new Enemigo();
        this.posJugador = prepararMapa();

    }

    //la función de este método es crear el tesoro. El número aleatorio se generá en el constructor.
    public void situarTesoro(){
        for (int fila = 0; fila < tablero.length; fila++){
            for (int col = 0; col < tablero[fila].length; col++){
                if (fila == posTesoro.getCoordenadaFila() && col == posTesoro.getCoordenadaCol()){
                    tablero[fila][col] = 't';
                }
            }
            }
    }
    public Posicion prepararMapa(){
        System.out.println("Introduzca su nombre de jugador");

        Scanner sc = new Scanner(System.in);
        String nombreJugador = sc.next();

        Explorador jugador = new Explorador(nombreJugador);
        this.posJugador = jugador.getPosicion();
        tablero[posJugador.getCoordenadaFila()][posJugador.getCoordenadaCol()] = 'J';


        do {
            // Primero creo nuevas objetos de Enemigo, que se soobreescriben en caso de que las coordenadas coincidan.
            Enemigo1 = new Enemigo();
            Enemigo2 = new Enemigo();
            Enemigo3 = new Enemigo();
        } while (

                Enemigo1.getPosicion().equals(posJugador) ||
                Enemigo2.getPosicion().equals(posJugador) ||
                Enemigo3.getPosicion().equals(posJugador) ||

                Enemigo1.getPosicion().equals(Enemigo2.getPosicion()) ||
                Enemigo1.getPosicion().equals(Enemigo3.getPosicion()) ||
                Enemigo2.getPosicion().equals(Enemigo3.getPosicion()) ||

                Enemigo1.getPosicion().equals(posTesoro) ||
                Enemigo2.getPosicion().equals(posTesoro) ||
                Enemigo3.getPosicion().equals(posTesoro)
        );
        // Una vez es seguro que las coordenadas son diferentes, los introducimos en la matriz
        tablero[Enemigo1.getPosicion().getCoordenadaFila()][Enemigo1.getPosicion().getCoordenadaCol()] = 'E';
        tablero[Enemigo2.getPosicion().getCoordenadaFila()][Enemigo2.getPosicion().getCoordenadaCol()] = 'E';
        tablero[Enemigo3.getPosicion().getCoordenadaFila()][Enemigo3.getPosicion().getCoordenadaCol()] = 'E';

        return posJugador;
    }

    public void ronda(){



    }



    public char[][] getTablero() {
        return tablero;
    }

    public void setTablero(char[][] tablero) {
        this.tablero = tablero;
    }


    public void mostrar(){
        System.out.println("----------------------------------------------------------------------------------");
        for (int fila = 0; fila < tablero.length; fila++){
                for (int col = 0; col < tablero[fila].length; col++){
                    System.out.print(" | ");
                    System.out.print(tablero[fila][col]);

                }
            System.out.print(" | ");
            System.out.println();
            System.out.print("----------------------------------------------------------------------------------");
            System.out.println();

        }
    }
}
