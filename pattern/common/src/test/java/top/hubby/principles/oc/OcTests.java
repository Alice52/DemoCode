package top.hubby.principles.oc;

import org.junit.Test;
import top.hubby.principles.oc.impl.DefaultSkin;
import top.hubby.principles.oc.impl.HubbySkin;

/**
 * @author zack <br>
 * @create 2021-09-13<br>
 * @project pattern <br>
 */
public class OcTests {

    @Test
    public void testSkin() {

        SouInput souInput = new SouInput();

        // not change default skin: change closed
        DefaultSkin skin = new DefaultSkin();
        souInput.setSkin(skin);
        souInput.display();

        // define new skin to extended: ext open
        HubbySkin skin2 = new HubbySkin();
        souInput.setSkin(skin2);
        souInput.display();
    }
}
