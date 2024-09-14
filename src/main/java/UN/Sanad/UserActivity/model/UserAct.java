package UN.Sanad.UserActivity.model;

import UN.Sanad.Activity.model.Activity;
import UN.Sanad.User.model.Users;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class UserAct {
    @Id
    @GeneratedValue
    private Integer id;
    private boolean enrolled;
    private boolean registered;
    private boolean favourite;
    private int bucketMoney;

    @ManyToOne
    @JoinColumn(name = "User_id")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "Activity_id")
    private Activity activity;
}
