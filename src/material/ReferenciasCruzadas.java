package material;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;


/**
 *
 * @author mayte
 */
public class ReferenciasCruzadas {
   TreeMap<String, LinkedList<Integer>> mapa;
    /**
    * Builds an ordered dictionary from a file
    * 
    * @param fichero
    * @throws IOException
    */
    public ReferenciasCruzadas (FileReader fichero) throws IOException{
        Scanner sc   =   new   Scanner(fichero).useDelimiter("\\`|\\~|\\!|\\@|\\#|\\$|\\%|\\^|\\&|\\*|\\(|\\)|\\+|\\=|\\[|\\{|\\]|\\}|\\||\\\\|\\'|\\<|\\,|\\.|\\ >|\\?|\\/|\\\"\"|\\;|\\:|\\s+");
        mapa=new TreeMap<>();
        int cont=1;
        while(sc.hasNext()){
            String x = sc.next();
            if(x.equals(""))continue;
            if(x.equals(" "))continue;
            if(mapa.containsKey(x)){
                mapa.get(x).addLast(cont);
            }
            else{
                mapa.put(x,new LinkedList<>());
                mapa.get(x).addLast(cont);
            }
            cont++;
        }


    }
    
    /**
    * Returns the list of indexes that the word occupies in the text with which the dictionary has been built. 
    * If the word does not belong to the file returns null
    * @param word     
    * @return      
    */
    public List<Integer> apariciones(String word){
        return mapa.get(word);
    }
    
}
