package UN.Sanad.Activity.dto;

import UN.Sanad.Activity.enums.ActivityEn;
import UN.Sanad.EmpAct.dto.EmpActDto;
import UN.Sanad.UserAct.dto.UserActDto;


import java.time.LocalDateTime;
import java.util.List;

public record ActivityDto(

         String name,
         String description,
         String category,
         LocalDateTime startDate,
         int duration,
         int budget,
         ActivityEn type,
         List<UserActDto> userActs,
         List<EmpActDto> actEmps

) {
}
