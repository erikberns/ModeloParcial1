package impl;
import api.PilaColaTDA;

public class PilaColaDinamica implements PilaColaTDA {

    Nodo primero;
    Nodo ultimo;
    int contador_pares;

    public void inicializar() {
        primero = null;
        ultimo = null;
        contador_pares = 0;
    }

    public void cargar(int x) {
        Nodo aux = new Nodo();
        aux.info = x;

        if (primero == null) {
            primero = aux;
            ultimo = aux;
        }
        else{
            if(contador_pares <= 10){
                //cola al final
                ultimo.sig = aux;
                ultimo = aux;
            }
            if(contador_pares > 10){
                //pila
                aux.sig = primero;
                primero = aux; 
            }
        }
        if(x%2 == 0){
            contador_pares = contador_pares + 1;
        }
    }

    public void quitar() {
        int x = 0;
        if(contador_pares <= 10){
            //cola
            Nodo salto = primero;
                while (salto.sig!=null) {
                    if(salto.sig == ultimo){
                        ultimo = salto;
                        ultimo.sig = null;
                        x = salto.info;
                    }
                    if (salto.sig!= null) {
                        salto = salto.sig;    
                    }
                }
        }
        else{
            if(contador_pares > 10){
                // pila
                x = primero.info;
                primero = primero.sig;
            }
        }
        if(x%2 == 0){
            contador_pares = contador_pares - 1;
        }
    }

    public int topeOprimero() {
        int valor = 0;
        if(contador_pares<= 10){
            //cola
            valor = ultimo.info;
        }
        else{
            if(contador_pares > 10){
                //pila
                valor = primero.info;
            }
        }
        return valor;
    }

    public boolean estaVacio() {
        return(primero == null);
    }

    public void imprimirTodo() {
        Nodo salto = primero;
        while (salto != null) {
            System.out.println(salto.info);
            salto = salto.sig;
        }
    }
}