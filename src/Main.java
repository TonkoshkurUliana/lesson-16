import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {

        Class<Human> c = Human.class;
        System.out.println("Name of class = " + c.getName());
        System.out.println("Simple Name of class = " + c.getSimpleName());
        System.out.println("Type Name of class = " + c.getTypeName());
        System.out.println("Class modifier = " + Modifier.toString(c.getModifiers()) + " int = " + c.getModifiers());
        System.out.println("is static = " + Modifier.isStatic(c.getModifiers()));
        System.out.println("is public = " + Modifier.isPublic(c.getModifiers()));
        System.out.println("is abstract = " + Modifier.isAbstract(c.getModifiers()));
        System.out.println("Package of current class = " + c.getPackage());
        System.out.println("Super class = " + c.getSuperclass());
        System.out.println("Interfaces =  " + Arrays.toString(c.getInterfaces()));

        System.out.println("Constructor print: ");
        Constructor[] constructors = c.getConstructors();
        for (int i = 0 ;i<constructors.length;i++){
            Constructor constructor =constructors[i];
            System.out.println("----> "+constructor);
        }

        System.out.println("Methods print: ");
        Method[] methods = c.getMethods();
        for (int i = 0 ;i<methods.length;i++){
            Method method =methods[i];
            System.out.println("----> "+method);
        }
        System.out.println("Field print: ");
        Field[] fields = c.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
                System.out.println(field);
        }

        Constructor<Human> singleClass = c.getConstructor (String.class, String.class, int.class);
        Human h = new Human("Pavlo", "Simonenko", 45);
        System.out.println("Class Human = " + h );


        Field ageField = c.getDeclaredField("age");
        ageField.setAccessible(true);
        ageField.set(h, 100);
        System.out.println("Person new age"+ h);

        Field nameField = c.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(h, "Dmytro");
        System.out.println("Person new name"+ h);

        Field privateLastNameField = fields[1];
        privateLastNameField.setAccessible(true);
        System.out.println("Private Value = "+ privateLastNameField.get(h));

        methods[6].invoke(h,"Carla");
        System.out.println(h);
    }
}