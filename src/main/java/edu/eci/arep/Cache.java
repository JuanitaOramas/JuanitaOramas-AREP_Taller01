package edu.eci.arep;


import java.util.HashMap;
import java.util.Map;


public class Cache {

    public  static  Map<String, String> cache= new HashMap<String, String>();

    /** Método main, que almacena el caché @param key
     * @param values
     */

    public static void saveCache(String key, String values) {
        cache.put(key,values);
    }

    public static boolean containCache(String values) {
        return  cache.containsKey(values);
    }

    public static String getCache(String key) {
        String values = "";
        if (cache.containsKey(key)){values =cache.get(key);}
        return values;
    }



}
