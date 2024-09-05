package UN.Sanad.Employee.model;

import UN.Sanad.EmpAct.model.ActEmp;
import UN.Sanad.User.model.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Integer id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private boolean isCoach;

    private int salary;

    private int hours;

    @OneToMany(mappedBy ="employee",cascade = CascadeType.ALL)
    List<ActEmp> actEmpList;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
}
