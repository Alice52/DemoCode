package cn.edu.ntu.javaee.annotation.impor.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * import classes[full class name] from ImportSelector to IOC container. <br>
 *
 * @author zack <br>
 * @create 2020-04-29 21:44 <br>
 */
public class CustomImportSelector implements ImportSelector {

    /**
     * @param importingClassMetadata Metadata info about class marked by @Import annotation, such as
     *     other annotation, annotation info
     * @return String[] return the names of which class(es) should be imported
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String className = importingClassMetadata.getClassName();
        return new String[] {"cn.edu.ntu.javaee.annotation.common.model.Employee"};
    }
}
