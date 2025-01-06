import java.util.Scanner;

public class Mapa {
    public char tablero[][];
    private Posicion posTesoro;
    private Posicion posJugador;
    private Enemigo listadoEnemigos;
    private Posicion posicionTrampas;

    public Mapa(){
        this.tablero = new char[6][20];
        this.posTesoro = new Posicion((int)(Math.random()*6) ,(int)(Math.random()*20));
        situarTesoro();
        this.posJugador = crearYSituarJugador();

    }

    //la función de este método es crear el tesoro.
    public void situarTesoro(){
        for (int fila = 0; fila < tablero.length; fila++){
            for (int col = 0; col < tablero[fila].length; col++){
                if (fila == posTesoro.getCoordenadaFila() && col == posTesoro.getCoordenadaCol()){
                    tablero[fila][col] = 't';
                }
            }
            }
    }
    public Posicion crearYSituarJugador(){
        System.out.println("Introduzca su nombre de jugador");

        Scanner sc = new Scanner(System.in);
        String nombreJugador = sc.next();

        Explorador jugador = new Explorador(nombreJugador);


        for (int fila = 0; fila < tablero.length; fila++) {
            for (int col = 0; col < tablero[fila].length; col++) {
                if (fila == jugador.getPosicion().getCoordenadaFila() && col == jugador.getPosicion().getCoordenadaCol()) {
                    tablero[fila][col] = 'J';
                } else if (tablero[fila][col] != 'J' && tablero[fila][col] != 't') {
                    tablero[fila][col] = ' ';

                }

            }
        }
        return jugador.getPosicion();
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
