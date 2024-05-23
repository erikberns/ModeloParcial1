import api.PilaColaTDA;
import impl.PilaColaDinamica;

public class App {
    public static void main(String[] args) throws Exception {
        PilaColaTDA pc = new PilaColaDinamica();
        
        pc.inicializar();
        pc.cargar(1);
        pc.cargar(2);
        pc.cargar(2);
       

        System.out.println(pc.topeOprimero());
        

        pc.imprimirTodo();
    }
}
