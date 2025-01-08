import java.util.Scanner;

public class Explorador {
    private String nombre;
    private Posicion posicion;
    public static final int ARRIBA = 1;
    public static final int ABAJO = 2;
    public static final int DERECHA = 3;
    public static final int IZQUIERDA = 4;


    public Explorador(String queNombre){
        this.nombre = queNombre;
        this.posicion = new Posicion((int)(Math.random()*5) , 0);

    }

    public String getNombre() {
        return nombre;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public void moverse(int direccion) {
        switch (direccion) {
            case ARRIBA:
                if (getPosicion().getCoordenadaFila() > 0){
                posicion.setCoordenadaFila(posicion.getCoordenadaFila() - 1);
                }
                break;
            case ABAJO:
                posicion.setCoordenadaFila(posicion.getCoordenadaFila() + 1);
                break;
            case DERECHA:
                posicion.setCoordenadaCol(posicion.getCoordenadaCol() + 1);
                break;
            case IZQUIERDA:
                posicion.setCoordenadaCol(posicion.getCoordenadaCol() - 1);
                break;

        }

}}


