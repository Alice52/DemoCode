package top.hubby.principles.oc;

import lombok.Data;

/**
 * @author zack <br>
 * @create 2021-09-13<br>
 * @project pattern <br>
 */
@Data
public class SouInput {
    private AbstractSkin skin;

    public void display() {
        skin.display();
    }
}
