package cn.edu.ntu.javase.syntax;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is for test the cn.edu.ntu.javase.enumeration.usage of Properties.<br>
 *
 * @author zack <br>
 * @create 2020-01-31 11:03 <br>
 */
public class PropertiesUsage {
    private static final Logger LOG = LoggerFactory.getLogger(PropertiesUsage.class);
    private static final String FILE_PATH = "";
    private static final String SPECIFY_PROP = "";
    private static final String DEFAULT_PROP_VALUE = "";

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(FILE_PATH));
        properties.getProperty(SPECIFY_PROP, DEFAULT_PROP_VALUE);
    }
}
