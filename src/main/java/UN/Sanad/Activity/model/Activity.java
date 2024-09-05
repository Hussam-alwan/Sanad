package UN.Sanad.Activity.model;

import UN.Sanad.Activity.enums.ActivityEn;
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
    private String name;
    private String description;
    private String category;
    private LocalDateTime startDate;
    private int duration;
    private int budget;

    @Enumerated(EnumType.STRING)
    private ActivityEn type;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    private List<UserAct> userActs;

    @OneToMany(mappedBy = "activity", cascade = CascadeType.ALL)
    private List<ActEmp> actEmps;

}
