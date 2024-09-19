package UN.Sanad.User.model;

import UN.Sanad.UserActivity.model.UserAct;
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
public class    Users {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 20)

    private String firstName;
    private String lastName;

    @Column(unique = true)
    @Email
    private String email;

    private String password;

    private LocalDateTime brithDate;

    private String gender;

    private String address;

    private String phoneNumber;

    public Users(String firstName, String lastName, String email,String password, String gender, String address, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password=password;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<UserAct> userActivities;


}