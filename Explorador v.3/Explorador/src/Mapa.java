import java.util.Scanner;

public class Mapa {
    public char tablero[][];
    private Posicion posTesoro;
    private Explorador posJugador;
    private Enemigo Enemigo1;
    private Enemigo Enemigo2;
    private Enemigo Enemigo3;
    private Posicion[] posicionTrampas;


    public Mapa(){
        this.tablero = new char[6][20];
        this.posTesoro = new Posicion((int)(Math.random()*6) ,(int)(Math.random()*20));
        situarTesoro();
        this.Enemigo1  = new Enemigo();
        this.Enemigo2  = new Enemigo();
        this.Enemigo3  = new Enemigo();
        this.posJugador = prepararMapa();
        this.posicionTrampas = new Posicion[3];
        situarTrampas();

    }

    public void setTablero(char[][] tablero) {
        this.tablero = tablero;
    }
    public char[][] getTablero() {
        return tablero;
    }

    //la función de este método es crear el tesoro. El número aleatorio se genera en el constructor.

    public void situarTesoro(){
        for (int fila = 0; fila < tablero.length;fila++){
            for (int col = 0; col < tablero[fila].length;col++){
                if (fila == posTesoro.getCoordenadaFila() && col == posTesoro.getCoordenadaCol()){
                    tablero[fila][col] = ' ';
                }else tablero[fila][col] = ' ';
            }
        }


    }

    public void situarTrampas(){
        boolean falso = false;
        for (int i = 0; posicionTrampas.length > i; i++){
            Posicion trampa = new Posicion((int)(Math.random()*5), (int)(Math.random()*20));
            do {
                posicionTrampas[i] = trampa;
            }while ( falso);

            if      (trampa.equals(Enemigo1.getPosicion()) ||
                    trampa.equals(Enemigo2.getPosicion()) ||
                    trampa.equals(Enemigo3.getPosicion()) ||
                    trampa.equals(posTesoro) ||
                    trampa.equals(posJugador.getPosicion()) ||
                    (i > 0 && trampa.equals(posicionTrampas[i - 1])))
                    {
                        i--;

                    }
            else posicionTrampas[i] = trampa;
            tablero[trampa.getCoordenadaFila()][trampa.getCoordenadaCol()] = 'T';
            }
    }

    //Es un poco caótico, pero en este método también se crea el jugador del usuario.

    public Explorador prepararMapa(){
        System.out.println("Introduzca su nombre de jugador");

        Scanner sc = new Scanner(System.in);
        String nombreJugador = sc.next();

        this.posJugador = new Explorador(nombreJugador);

        tablero[posJugador.getPosicion().getCoordenadaFila()][posJugador.getPosicion().getCoordenadaCol()] = 'J';


        do {
            // Primero creo nuevas objetos de Enemigo, que se soobreescriben en caso de que las coordenadas coincidan.
            Enemigo1 = new Enemigo();
            Enemigo2 = new Enemigo();
            Enemigo3 = new Enemigo();

        } while (

                Enemigo1.getPosicion().equals(posJugador.getPosicion()) ||
                Enemigo2.getPosicion().equals(posJugador.getPosicion()) ||
                Enemigo3.getPosicion().equals(posJugador.getPosicion()) ||

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
    public void ronda() {
        boolean juego = true;
        Scanner sc = new Scanner(System.in);
        String decision;

        while (juego) {

            mostrar();
            /*System.out.println(posicionTrampas[0].getCoordenadaCol());
            System.out.println(posicionTrampas[0].getCoordenadaFila());
            System.out.println(posicionTrampas[1].getCoordenadaCol());
            System.out.println(posicionTrampas[1].getCoordenadaFila());
            System.out.println(posicionTrampas[2].getCoordenadaCol());
            System.out.println(posicionTrampas[2].getCoordenadaFila());*/

            if
            (posJugador.getPosicion().getCoordenadaCol() == Enemigo1.getPosicion().getCoordenadaCol() && posJugador.getPosicion().getCoordenadaFila() == Enemigo1.getPosicion().getCoordenadaFila() ||
            posJugador.getPosicion().getCoordenadaCol() == Enemigo2.getPosicion().getCoordenadaCol() && posJugador.getPosicion().getCoordenadaFila() == Enemigo2.getPosicion().getCoordenadaFila() ||
            posJugador.getPosicion().getCoordenadaCol() == Enemigo3.getPosicion().getCoordenadaCol() && posJugador.getPosicion().getCoordenadaFila() == Enemigo3.getPosicion().getCoordenadaFila())
                    {
                System.out.println("perdiste");
                juego = false;
                break;
            }
            if (posJugador.getPosicion().getCoordenadaFila() == posTesoro.getCoordenadaFila() && posJugador.getPosicion().getCoordenadaCol() == posTesoro.getCoordenadaCol()) {
                System.out.println("¡Has ganado! Encontraste el tesoro.");
                juego = false;
                break;
            }
            if (posJugador.getPosicion().getCoordenadaFila() == posicionTrampas[0].getCoordenadaFila() && posJugador.getPosicion().getCoordenadaCol() == posicionTrampas[0].getCoordenadaCol() ||
            posJugador.getPosicion().getCoordenadaFila() == posicionTrampas[1].getCoordenadaFila() && posJugador.getPosicion().getCoordenadaCol() == posicionTrampas[1].getCoordenadaCol() ||
            posJugador.getPosicion().getCoordenadaFila() == posicionTrampas[2].getCoordenadaFila() && posJugador.getPosicion().getCoordenadaCol() == posicionTrampas[2].getCoordenadaCol()){
                juego = false;
                System.out.println("has perdido, has pisado una mina");
                break;
            }
            // Mostrar el tablero


            // Pedir al jugador que elija un movimiento
            System.out.println("¿Qué deseas hacer, aventurero?");
            System.out.println("W: ir arriba, S: ir abajo, A: ir izquierda, D: ir derecha");
            do {
                decision = sc.next().toUpperCase(); // Convertir la entrada a mayúsculas
                if (!decision.equals("W") && !decision.equals("S") &&
                        !decision.equals("A") && !decision.equals("D")) {
                    System.out.println("Entrada no válida. Usa W, S, A o D.");
                }
            } while (!decision.equals("W") && !decision.equals("S") &&
                    !decision.equals("A") && !decision.equals("D"));

            // Borrar la posición actual del jugador
            tablero[posJugador.getPosicion().getCoordenadaFila()][posJugador.getPosicion().getCoordenadaCol()] = ' ';

            // Mover al jugador según la decisión
            switch (decision) {
                case "W":
                    posJugador.moverse(Explorador.ARRIBA);
                    break;
                case "S":
                    posJugador.moverse(Explorador.ABAJO);
                    break;
                case "A":
                    posJugador.moverse(Explorador.IZQUIERDA);
                    break;
                case "D":
                    posJugador.moverse(Explorador.DERECHA);
                    break;
            }

            // Perimero borro las posiciones de los enemigos, y las vuelvo a poner una vez se han movido.
            tablero[Enemigo1.getPosicion().getCoordenadaFila()][Enemigo1.getPosicion().getCoordenadaCol()] = ' ';
            tablero[Enemigo2.getPosicion().getCoordenadaFila()][Enemigo2.getPosicion().getCoordenadaCol()] = ' ';
            tablero[Enemigo3.getPosicion().getCoordenadaFila()][Enemigo3.getPosicion().getCoordenadaCol()] = ' ';

            Enemigo1.moverse();
            Enemigo2.moverse();
            Enemigo3.moverse();

            tablero[Enemigo1.getPosicion().getCoordenadaFila()][Enemigo1.getPosicion().getCoordenadaCol()] = 'E';
            tablero[Enemigo2.getPosicion().getCoordenadaFila()][Enemigo2.getPosicion().getCoordenadaCol()] = 'E';
            tablero[Enemigo3.getPosicion().getCoordenadaFila()][Enemigo3.getPosicion().getCoordenadaCol()] = 'E';
            tablero[posJugador.getPosicion().getCoordenadaFila()][posJugador.getPosicion().getCoordenadaCol()] = 'J';


        }
    }

}
