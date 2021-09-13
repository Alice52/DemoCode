package top.hubby.principles.oc.impl;

import lombok.extern.slf4j.Slf4j;
import top.hubby.principles.oc.AbstractSkin;

/**
 * @author zack <br/>
 * @create 2021-09-13<br/>
 * @project pattern <br/>
 */
@Slf4j
public class HubbySkin extends AbstractSkin {
    @Override
    public void display() {
        log.info("hubby skin");
    }
}
