package UN.Sanad.EmployeeActivity.model;

import UN.Sanad.Activity.model.Activity;
import UN.Sanad.Employee.model.Employee;
import jakarta.persistence.*;
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
    private String name;


    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

}
