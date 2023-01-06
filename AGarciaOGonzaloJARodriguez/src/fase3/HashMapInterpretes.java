package fase3;

public class HashMapInterpretes<K,V> {
    private ItemInterpretes<K,V>[] tabla;
    ItemInterpretes<K,V> noItem = new ItemInterpretes<K,V>(null, null);
    private int size;
    private int maxsize;
    
    public HashMapInterpretes(int maxsize){
        this.maxsize = maxsize;
        this.tabla = (ItemInterpretes<K,V>[]) new ItemInterpretes<K,V>[maxsize];
    }
    
    public void put(K key, V value){
        if (this.size == maxsize*0.5) {
            //ampliar la tabla
        }
        
        
        size++;
    }
    public V get(K key){
        return null;
    }
    public V remove(K key){return null;}
    public boolean containsKey(K key){
        return false;
    }
    public boolean isEmpty(){
        return size==0;
    }
}
