package top.hubby.practice.serialize.after.v2;

import lombok.extern.slf4j.Slf4j;

/**
 * @author asd <br/>
 * @create 2021-12-21 4:41 PM <br/>
 * @project pattern <br/>
 */
public interface Serializable {
    String serialize(Object object);
}
