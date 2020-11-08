package converter;

import model.Patient;
import model.PatientDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author zack <br>
 * @create 2020-11-08 23:30 <br>
 * @project springboot <br>
 */
@Mapper
public interface PatientMapper {
  PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);

  PatientDto toDto(Patient patient);
}
