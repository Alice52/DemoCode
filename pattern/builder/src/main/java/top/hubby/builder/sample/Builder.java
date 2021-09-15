package top.hubby.builder.sample;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zack <br>
 * @create 2021-09-15<br>
 * @project pattern <br>
 */
@Slf4j
public abstract class Builder {

    protected BikeProduct mBike = new BikeProduct();

    public abstract void buildFrame();

    public abstract void buildSeat();

    public BikeProduct build() {
        return mBike;
    }
}
