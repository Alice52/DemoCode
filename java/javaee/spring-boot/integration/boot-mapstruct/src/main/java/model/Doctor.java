package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zack <br>
 * @create 2020-11-08 23:09 <br>
 * @project springboot <br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Doctor {
  private int id;
  private String name;
  private String specialty;
  private List<Patient> patientList;
}
