package boot.webflux.server.repository;

import boot.webflux.server.entity.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zack <br>
 * @create 2021-04-11 14:32 <br>
 * @project springboot <br>
 */
@Repository
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {}
