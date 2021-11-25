package cn.edu.ntu.jackson.deserialize;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;

import java.util.List;

/**
 * @author asd <br>
 * @create 2021-11-25 5:53 PM <br>
 * @project json <br>
 */
@Slf4j
public class DesTestsTest {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @SneakyThrows
    private <E> List<E> readValue(@Nullable String payload, TypeReference<List<E>> reference) {
        return objectMapper.readValue(payload, reference);
    }
}
