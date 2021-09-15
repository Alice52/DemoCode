package top.hubby.builder.sample;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zack <br>
 * @create 2021-09-15<br>
 * @project pattern <br>
 */
@Slf4j
public class Director {
    private Builder mBuilder;

    public Director(Builder builder) {
        mBuilder = builder;
    }

    public BikeProduct construct() {
        mBuilder.buildFrame();
        mBuilder.buildSeat();
        return mBuilder.build();
    }
}
