package fase3;

import java.util.LinkedList;
import java.util.concurrent.Flow.Publisher;

public class ItemInterpretes<K,V> {
    K clave;
    V valor;
    public ItemInterpretes(K clave, V valor){
        this.clave = clave;
        this.valor = valor;
    }
    
}
