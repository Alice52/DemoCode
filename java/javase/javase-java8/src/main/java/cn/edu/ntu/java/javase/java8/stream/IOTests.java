package cn.edu.ntu.java.javase.java8.stream;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author asd <br>
 * @create 2021-12-08 10:35 AM <br>
 * @project javase <br>
 */
@Slf4j
public class IOTests {

    @Test
    public void testStreamIO() {
        Path path = Paths.get("pom.xml");

        try (Stream<String> lines = Files.lines(path)) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
