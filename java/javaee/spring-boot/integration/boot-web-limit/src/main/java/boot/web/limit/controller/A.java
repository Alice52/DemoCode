package boot.web.limit.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zack <br>
 * @create 2021-04-15 15:35 <br>
 * @project integration <br>
 */
public class A {
  public static void main(String[] args) {

    System.out.println(RandomUtil.randomInt());

    Integer a1 = new Integer(12);
    Integer a2 = new Integer(12);
    Integer b1 = -129;
    Integer b2 = -129;
    Integer c1 = 127;
    Integer c2 = 127;
    System.out.println(a1 == a2); // false
    System.out.println(b1 == b2); // false
    System.out.println(c1 == c2); // true

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

    System.out.println(JSONUtil.isJson(jsonStr));

    JSONObject jsonObject = JSONUtil.toBean(jsonStr, JSONObject.class);

    System.out.println(jsonObject);
  }
}
