package top.hubby.processor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.hubby.annotations.Serial;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

/**
 * @author alice52
 */
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("cn.edu.ntu.java.annotation.Serial")
public class SerialProcessor extends AbstractProcessor {

    private static final Logger log = LoggerFactory.getLogger(SerialProcessor.class);

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement te : annotations) {
            for (Element e : roundEnv.getElementsAnnotatedWith(te)) {
                Serial util = e.getAnnotation(Serial.class);
                if (util != null) {
                    final String value = util.value();
                    log.info(">>>>>>>>>>>> util value: " + value);
                    // 1. 如果打印 error, 直接直接中断
                    processingEnv
                            .getMessager()
                            .printMessage(
                                    Diagnostic.Kind.WARNING, ">>>>>>>>>>>> util value = " + value);
                }
            }
        }
        return true;
    }
}
