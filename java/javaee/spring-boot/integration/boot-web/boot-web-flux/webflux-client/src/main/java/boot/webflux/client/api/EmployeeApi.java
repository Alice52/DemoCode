package boot.webflux.client.api;

import boot.webflux.client.annotation.ApiServer;
import boot.webflux.client.model.dto.Employee;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author zack <br>
 * @create 2021-04-11 16:08 <br>
 * @project springboot <br>
 */
@ApiServer("localhost:8080")
public interface EmployeeApi {

  @GetMapping("/employees")
  Flux<Employee> list();

  @GetMapping("/employee/{id}")
  Mono<Employee> get(@PathVariable("id") String id);

  @DeleteMapping("/employee/{id}")
  Mono<Void> delete(@PathVariable("id") String id);

  @PostMapping("/employee")
  Mono<Employee> create(@RequestBody Mono<Employee> employee);
}
