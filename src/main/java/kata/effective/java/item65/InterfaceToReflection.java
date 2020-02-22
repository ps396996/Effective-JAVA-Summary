package kata.effective.java.item65;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

public class InterfaceToReflection {

  public static void main (String[] args){
    // Translate the class name into a class object
    Class<?> cl =  null;
    try{
      cl = Class.forName(args[0]);// Class is specified by the first command line argument
    }catch(ClassNotFoundException e){
      System.err.println("Class not found");
      System.exit(1);
    }

    //Instantiate the class
    Set<String> s = null;
    try{
      s = (Set<String>) cl.getDeclaredConstructor().newInstance(); //  The class can be either a HashSet or a TreeSet
    } catch(IllegalAccessException e){
      System.err.println("Class not accessible");
      System.exit(1);
    }catch(InstantiationException e){
      System.err.println("Class not instantiable");
      System.exit(1);
    } catch (NoSuchMethodException | InvocationTargetException e) {
      e.printStackTrace();
    }

    //Excercise the Set
    // Print the remaining arguments. The order depends in the class. If it is a HashSet
    // the order will be random, if it is a TreeSet it will be alphabetically
    s.addAll(Arrays.asList(args).subList(1,args.length));
    System.out.println(s);
  }
}
