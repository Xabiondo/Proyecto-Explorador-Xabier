import java.util.Scanner;

public class JuegoExplorador {
    private Explorador jugador;
    private Mapa mapa;

    public JuegoExplorador(){
        this.jugador = new Explorador("xabi");
        this.mapa = new Mapa();


    }

    public void Juego(){

        for (int i =0  ; 5 > i ; i++) {

            int eleccion = 0;
            do {
                System.out.println("Que deseas hacer");
                System.out.println("mover arriba = 1 , mover abajo = 2 , mover derecha = 3 , mover izquierda = 4");

                Scanner sc = new Scanner(System.in);

                eleccion = sc.nextInt();

            } while (eleccion >= 5);

            jugador.Moverse(eleccion);
            for (int fila = 0; fila < mapa.tablero.length; fila++) {
                for (int col = 0; col < mapa.tablero[fila].length; col++) {
                    if (fila == jugador.getPosicion().getCoordenadaFila() && col == jugador.getPosicion().getCoordenadaCol()) {
                        mapa.tablero[fila][col] = 'J';
                    } else if (mapa.tablero[fila][col] != 'J' && mapa.tablero[fila][col] != 't') {
                        mapa.tablero[fila][col] = ' ';

                    }

                }
            }
            mapa.mostrar();
        }








    }
}
