package UN.Sanad.EmpAct.model;

import UN.Sanad.Activity.model.Activity;
import UN.Sanad.Employee.model.Employee;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class ActEmp {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Employee employee;

    @ManyToOne
    private Activity activity;

}
