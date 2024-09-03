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
@DiscriminatorValue("Manager")
public class Manager extends Employee {
    private String specialization;
}
