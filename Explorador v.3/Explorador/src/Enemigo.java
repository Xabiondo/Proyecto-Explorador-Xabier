public class Enemigo {
    private Posicion posicion;

    public Enemigo(){
        this.posicion = new Posicion((int)(Math.random()*5) , (int)(Math.random()*19));
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }

    public Posicion moverse() {
        int direccion = (int) (Math.random() * 4 + 1);


        switch (direccion) {
            case Explorador.ARRIBA:

                if (this.posicion.getCoordenadaFila() > 0) {
                    posicion.setCoordenadaFila(getPosicion().getCoordenadaFila() - 1);
                } else {
                    posicion.setCoordenadaFila(getPosicion().getCoordenadaFila() + 1);
                }
                break;

            case Explorador.ABAJO:
                // Si puede bajar, baja; de lo contrario, sube.
                if (this.posicion.getCoordenadaFila() < 5) {
                    posicion.setCoordenadaFila(getPosicion().getCoordenadaFila() + 1);
                } else {
                    posicion.setCoordenadaFila(getPosicion().getCoordenadaFila() - 1);
                }
                break;

            case Explorador.DERECHA:

                if (this.posicion.getCoordenadaCol() < 19) {
                    posicion.setCoordenadaCol(getPosicion().getCoordenadaCol() + 1);
                } else {
                    posicion.setCoordenadaCol(getPosicion().getCoordenadaCol() - 1);
                }
                break;

            case Explorador.IZQUIERDA:

                if (this.posicion.getCoordenadaCol() > 0) {
                    posicion.setCoordenadaCol(getPosicion().getCoordenadaCol() - 1);
                } else {
                    posicion.setCoordenadaCol(getPosicion().getCoordenadaCol() + 1);
                }
                break;
        }
        return posicion;
    }

}
