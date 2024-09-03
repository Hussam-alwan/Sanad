package UN.Sanad.Activity.model;

import UN.Sanad.EmpAct.model.ActEmp;
import UN.Sanad.UserAct.model.UserAct;
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
    private String description;
    private String category;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int budget;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    private List<UserAct> userActs;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    private List<ActEmp> actEmps;

}
