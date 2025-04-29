package edu.icet.ecom.dto;
import lombok.*;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Employee {
    private Integer id;
    private String name;
    private String email;
    private String department;
    private LocalDate createdAt;
    private LocalDate updatedAt;

}

