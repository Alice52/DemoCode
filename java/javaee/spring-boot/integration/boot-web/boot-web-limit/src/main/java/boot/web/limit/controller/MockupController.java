package boot.web.limit.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class MockupController {

  private static int a = 0;

  @PutMapping("/game")
  public Object api1() {

    a += 1;
    log.info("a: {}", a);

    return new HashMap<String, String>() {
      {
        put("id", UUID.randomUUID().toString());
      }
    };
  }

  @SneakyThrows
  @GetMapping("/game/{id}/puzzle")
  public Object api2(@PathVariable("id") String id) {
    log.info("a: {}", a);
    List<String> list =
        new ArrayList<String>() {
          {
            add("normal");
            add("easteregg");
            add("brainstorm");
            add("difficult");
          }
        };

    String jsonStr =
        "{ \"type\": \""
            + list.get(RandomUtil.randomInt(4))
            + "\", \"caps\": [ { \"img\": \"https://s.im5i.com/2021/04/12/5ough.png\", \"logo\": \"\" }, { \"img\": \"https://s.im5i.com/2021/04/12/5o3VX.png\", \"logo\": \"\" }, { \"img\": \"https://s.im5i.com/2021/04/12/5o4Qf.png\", \"logo\": \"\" }, { \"img\": \"https://s.im5i.com/2021/04/12/5oIUM.png\", \"logo\": \"\" }, { \"img\": \"https://s.im5i.com/2021/04/12/5oXk3.png\", \"logo\": \"\" }, { \"img\": \"https://s.im5i.com/2021/04/12/5oma7.png\", \"logo\": \"\" }, { \"img\": \"https://s.im5i.com/2021/04/12/5oHIp.png\", \"logo\": \"\" }, { \"img\": \"https://s.im5i.com/2021/04/12/5tDEv.png\", \"logo\": \"\" }, { \"img\": \"https://s.im5i.com/2021/04/12/5tU7G.png\", \"logo\": \"\" } ], \"question\": { \"img\":\"https://s.im5i.com/2021/04/12/5oKQs.png\", \"desc\":\"desc\" }, \"answer\": { \"caps\":[0], \"score\": 100, \"img\": \"https://s.im5i.com/2021/04/12/5ough.png\", \"name\": \"name\", \"desc\": \"desc\", \"hint\":{ \"img\":\"https://s.im5i.com/2021/04/12/5oKQs.png\", \"desc\": \"hintdesc\" } } }";

    JSONObject jsonObject = JSONUtil.toBean(jsonStr, JSONObject.class);

    return jsonObject;
  }
}
