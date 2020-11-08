import converter.DoctorMapper;
import lombok.extern.slf4j.Slf4j;
import model.Doctor;
import model.DoctorDto;
import org.junit.Test;

/**
 * @author zack <br>
 * @create 2020-11-08 23:11 <br>
 * @project springboot <br>
 */
@Slf4j
public class DoctorMapperTests {

  @Test
  public void testConvert() {
    DoctorDto doctorDto = DoctorMapper.INSTANCE.toDto(new Doctor());
    log.info("{}", doctorDto);
  }
}
