package hubby.typeconvert.converter;

import hubby.typeconvert.model.Customer;
import hubby.typeconvert.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

/**
 * @author asd <br>
 * @create 2022-02-09 2:04 PM <br>
 * @project boot-typeconvert <br>
 */
@Slf4j
public class ConverterTests {

    @Test
    public void testObjectToObjectConverter() {

        Customer customer = new Customer();
        customer.setId(1L);
        customer.setName("Peking");

        ConversionService conversionService = new DefaultConversionService();
        Person person = conversionService.convert(customer, Person.class);
        log.info("{}", person);

        Customer c2 = conversionService.convert(customer, Customer.class);
        assert c2 == customer;
    }
}
