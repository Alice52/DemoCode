package cn.edu.ntu.javaee.annotation.scan.filer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * @author zack <br>
 * @create 2020-04-29 17:44 <br>
 */
@Slf4j
public class CustomTypeFilter implements TypeFilter {

  /**
   * If class name contains dao will be include to IOC container. <br>
   *
   * @param metadataReader the metadata reader for the target class
   * @param metadataReaderFactory a factory for obtaining metadata readers for other classes (such
   *     as superclasses and interfaces)ConditionalOnProperty
   * @return whether this filter matches
   * @throws IOException in case of I/O failure when reading metadata
   */
  @Override
  public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory)
      throws IOException {
    // get target annotation metadata
    AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
    // get target class metadata: subClass, superClass, interface
    ClassMetadata classMetadata = metadataReader.getClassMetadata();
    String className = classMetadata.getClassName();
    log.info(className);
    // get target class resource info
    Resource resource = metadataReader.getResource();

    return className.contains("dao");
  }
}
