package UN.Sanad.User.model;

import UN.Sanad.UserAct.model.UserAct;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Users {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 20)

    private String name;

    @Column(unique = true)
    @Email
    private String email;

    private String password;

    private LocalDateTime brithDate;

    private String gender;

    private String address;

    private String phoneNumber;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<UserAct> userActs;


}