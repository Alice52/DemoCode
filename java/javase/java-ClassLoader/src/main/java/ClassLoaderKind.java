import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zack
 * @create 2019-12-13 21:29
 * @function
 */
public class ClassLoaderKind {
  private static final Logger LOG = LoggerFactory.getLogger(ClassLoaderKind.class);

  public static void main(String[] args) {
    Object object = new Object();
    LOG.info(String.valueOf(object.getClass().getClassLoader())); // bootstrap classloader == null

    Person person = new Person();
    // bootstrap classloader == null
    LOG.info(String.valueOf(person.getClass().getClassLoader().getParent().getParent()));
    // extension classloader == sun.misc.Launcher$ExtClassLoader@439f5b3d
    LOG.info(String.valueOf(person.getClass().getClassLoader().getParent()));
    // application[system] classloader == sun.misc.Launcher$AppClassLoader@18b4aac2
    LOG.info(String.valueOf(person.getClass().getClassLoader()));
    LOG.info(String.valueOf(ClassLoader.getSystemClassLoader()));
    LOG.info(String.valueOf(person.getClass().getClassLoader() == ClassLoader.getSystemClassLoader()));  // true
  }
}
