package UN.Sanad.Employee.model.source;

import UN.Sanad.Employee.model.Employee;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("Trainer")
public class Trainer extends Employee {

    private String specialization;
    private String experience;
    private String education;

}
