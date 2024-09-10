package UN.Sanad.Activity.Mapper;

import UN.Sanad.Activity.dto.ActivityDto;
import UN.Sanad.Activity.dto.ActivityResponseDto;
import UN.Sanad.Activity.model.Activity;
import UN.Sanad.Employee.Service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class ActivityMapper {
    private final EmployeeService employeeService;

    public ActivityMapper(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public ActivityResponseDto activityResponseDto(Activity activity) {
        var employee=employeeService.getManagerById(activity.getActivityManager().getId());
        return new ActivityResponseDto(
                activity.getId(),
                activity.getName(),
                activity.getDescription(),
                activity.getCategory(),
                activity.getCity(),
                employee.getUser().getFirstName(),
                activity.getStartDate(),
                activity.getDuration(),
                activity.getBudget()
        );
    }

    public Activity toActivity(ActivityDto activityDto) {
        var activity = new Activity();
        activity.setName(activityDto.name());
        activity.setDescription(activityDto.description());
        activity.setCategory(activityDto.category());
        activity.setCity(activityDto.city());
        activity.setStartDate(activityDto.startDate());
        activity.setDuration(activityDto.duration());
        activity.setBudget(activityDto.budget());
        activity.setActivityManager(employeeService.getManagerById(activityDto.managerId()));
        return activity;
    }

}
