package converter;

import model.Customer;
import model.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import utils.BooleanStrFormat;

/**
 * @author zack <br>
 * @create 2020-11-08 23:46 <br>
 * @project springboot <br>
 */
@Mapper(
    componentModel = "spring",
    uses = {BooleanStrFormat.class})
public interface CustomerMapper {

  CustomerMapper INSTANCES = Mappers.getMapper(CustomerMapper.class);

  @Mappings({
    @Mapping(source = "name", target = "customerName"),
    @Mapping(source = "isDisable", target = "disable")
    // customerDto.setDisable( booleanStrFormat.toStr( customer.getIsDisable() ) );
  })
  CustomerDto toCustomerDto(Customer customer);
}
