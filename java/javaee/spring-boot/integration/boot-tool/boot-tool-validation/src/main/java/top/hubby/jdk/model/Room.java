package top.hubby.jdk.model;

import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

/**
 * @author asd <br>
 * @create 2022-03-09 4:09 PM <br>
 * @project boot-typeconvert <br>
 */
@Slf4j
public class Room {
    @NotNull public String name;
    @AssertTrue public boolean finished;
}
