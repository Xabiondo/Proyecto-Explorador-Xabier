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

    public Posicion Moverse(int direccion){
        direccion = (int)(Math.random()*4+1);

        //La idea es que si sale direccion = 1, y no puede subir, que baje obligatoriamente y viceversa.
        switch (direccion){
            case Explorador.ARRIBA:
                if (this.posicion.getCoordenadaFila()>0){
                    posicion.setCoordenadaFila(-1);

                }else posicion.setCoordenadaFila(+1);
                break;

            case Explorador.ABAJO:
                if (this.posicion.getCoordenadaFila()< 6){
                    posicion.setCoordenadaFila(+1);

                }else posicion.setCoordenadaFila(-1);
                break;

            case Explorador.DERECHA:
                if (this.posicion.getCoordenadaCol() < 20){
                    posicion.setCoordenadaCol(+1);
                }
                else posicion.setCoordenadaCol(-1);
                break;
            case Explorador.IZQUIERDA:
                if (this.posicion.getCoordenadaCol() > 0 ){
                    posicion.setCoordenadaCol(-1);

                }else posicion.setCoordenadaCol(+1);
                break;


        }
        return posicion;


    }

}
