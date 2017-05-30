/**
 * 
 */
package jp.vstone.sota.common;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author nobutnk
 *
 */
public class ClassUtils {
    
    public static <T> Class<T> getClassForName(String className) {
        try {
            return (Class<T>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    @SuppressWarnings("unchecked")
    public static <T> T getInstance(Class<T> clazz, Class[] types, Object[] args) {
        Constructor constructor;
        try {
            constructor = clazz.getConstructor(types);
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        Object obj;
        try {
            obj = constructor.newInstance(args);
            return (T) obj;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

}
