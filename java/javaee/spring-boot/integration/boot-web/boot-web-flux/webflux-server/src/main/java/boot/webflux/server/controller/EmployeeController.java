package boot.webflux.server.controller;

import boot.webflux.server.entity.Employee;
import boot.webflux.server.repository.EmployeeRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;

/**
 * @author zack <br>
 * @create 2021-04-11 14:33 <br>
 * @project springboot <br>
 */
@RestController
public class EmployeeController {

    @Resource private EmployeeRepository employeeRepository;

    @PutMapping("/employee/{id}")
    public Mono<Employee> update(@PathVariable("id") String id, @RequestBody Employee employee) {

        return employeeRepository.save(employee);
    }

    @GetMapping("/employees")
    public Flux<Employee> list() {

        return employeeRepository.findAll();
    }

    @PostMapping("/employee")
    public Mono<Employee> create(@RequestBody Employee employee) {

        return employeeRepository.save(employee);
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

        return employeeRepository.findById(id).flatMap(e -> employeeRepository.delete(e));
    }

    @PutMapping(value = "/stream/employee/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Employee> updateStream(
            @PathVariable("id") String id, @RequestBody Employee employee) {

        return employeeRepository.save(employee);
    }

    @GetMapping(value = "/stream/employees", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Employee> listStream() {

        return employeeRepository.findAll();
    }

    @PostMapping(value = "/stream/employee", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Employee> createStream(@RequestBody Employee employee) {

        return employeeRepository.save(employee);
    }

    @DeleteMapping(value = "/stream/employee/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Void> deleteStream(@PathVariable("id") String id) {

        return employeeRepository.deleteById(id);
    }
}
