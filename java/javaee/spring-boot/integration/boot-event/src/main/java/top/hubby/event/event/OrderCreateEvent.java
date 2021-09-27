package top.hubby.event.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * @author asd <br>
 * @create 2021-09-27 2:41 PM <br>
 * @project boot-security-shiro <br>
 */
@Slf4j
public class OrderCreateEvent extends ApplicationEvent {

    private String name;
    private List<String> contentList;

    public OrderCreateEvent(Object source, String name, List<String> contentList) {
        super(source);
        this.name = name;
        this.contentList = contentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getContentList() {
        return contentList;
    }

    public void setContentList(List<String> contentList) {
        this.contentList = contentList;
    }
}
