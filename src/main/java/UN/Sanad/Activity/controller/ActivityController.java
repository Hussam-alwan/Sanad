package UN.Sanad.Activity.controller;

import UN.Sanad.Activity.model.Activity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActivityController {
    @GetMapping(name = "activities")
    public List<Activity> activities(){
        return null;
    }

}
