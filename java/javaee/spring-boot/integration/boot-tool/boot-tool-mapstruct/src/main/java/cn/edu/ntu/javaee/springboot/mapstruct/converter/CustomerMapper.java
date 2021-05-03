package cn.edu.ntu.javaee.springboot.mapstruct.converter;

import cn.edu.ntu.javaee.springboot.mapstruct.model.Customer;
import cn.edu.ntu.javaee.springboot.mapstruct.model.CustomerDto;
import cn.edu.ntu.javaee.springboot.mapstruct.utils.BooleanStrFormat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

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
