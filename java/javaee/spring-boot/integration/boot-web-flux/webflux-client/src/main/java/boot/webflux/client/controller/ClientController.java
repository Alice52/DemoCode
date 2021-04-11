package boot.webflux.client.controller;

import boot.webflux.client.api.EmployeeApi;
import boot.webflux.client.model.dto.Employee;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2021-04-11 16:15 <br>
 * @project springboot <br>
 */
@RequestMapping("/client")
@RestController
public class ClientController {

  @Resource private EmployeeApi employeeApi;

  @GetMapping("/employees")
  public Flux<Employee> list() {

    return employeeApi.list();
  }

  @PostMapping("/employee")
  public Mono<Employee> create(@RequestBody Employee employee) {

    return employeeApi.create(Mono.just(employee));
  }

  /**
   * flatMap is used to change data;<br>
   * map is used to convert data only;<br>
   *
   * @param id
   * @return
   */
  @DeleteMapping("/employee/{id}")
  public Mono<Void> delete(@PathVariable("id") String id) {

    return employeeApi.delete(id);
  }
}
