package cn.edu.ntu.javase.interview.cas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author zack <br>
 * @create 2021-01-20<br>
 * @project javase <br>
 */
@Slf4j
public class AtomicReferenceTest {

    public static void main(String[] args) {

        User z3 = new User("z3", 15);
        User l4 = new User("l4", 25);

        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);

        boolean success = atomicReference.compareAndSet(z3, l4);

        log.info("update z3 to l4 is success: {}, now user: {}", success, atomicReference.get());
    }
}

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
class User {
    String name;
    int age;
}
