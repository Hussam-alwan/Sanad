package UN.Sanad.Activity.model;

import UN.Sanad.Employee.model.Employee;
import UN.Sanad.EmployeeActivity.model.ActEmp;
import UN.Sanad.UserActivity.model.UserAct;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Activity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private String category;
    private String city;
    private LocalDateTime startDate;
    private int duration;
    private int budget;
    private String type;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    private List<UserAct> userActs;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    private List<ActEmp> actEmps;

    @ManyToOne
    @JoinColumn(name = "activity_manager_id")
    private Employee activityManager;

}
