import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SaveToRunner {
    public static void main(String[] args) {

        Class<?> cls = TextContainer.class;

        String path = cls.getAnnotation(SaveTo.class).path();

        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Saver.class)) {
                try {
                    method.invoke(cls.getConstructor().newInstance(), path);
                } catch (IllegalAccessException | InvocationTargetException | InstantiationException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
    }
}
