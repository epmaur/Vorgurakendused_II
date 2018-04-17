package ee.ttu.vorgurakendused.training;

import java.util.List;

import ee.ttu.vorgurakendused.config.CustomUserDetails;
import ee.ttu.vorgurakendused.users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
public class TrainingController {

    private TrainingService trainingService;
    @Autowired
    private UserService userService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @RequestMapping(value="/trainings/add", method=RequestMethod.POST)
    public Training addTraining(@RequestBody Training training) {
        CustomUserDetails userDetails = (CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        training.setCreater(userService.getUser(userDetails.getUsername()));
        return trainingService.addTraining(training);
    }

    @CrossOrigin
    @RequestMapping(value="/trainings", method=RequestMethod.GET, produces="application/json")
    public List<Training> getAllTrainings() {
        List<Training> response = trainingService.getAllTrainings();
        return response;
    }

    @RequestMapping(value = "/trainings/{id}", method=RequestMethod.GET, produces="application/json")
    public Training getTraining(@PathVariable("id") int trainingId) {
        return trainingService.getTrainingById(trainingId);
    }

    @RequestMapping(value="/trainings/delete", method=RequestMethod.POST,
            consumes = "application/json")
    public Long deleteTraining(@RequestBody long id) {
        return trainingService.deleteTrainingById(id);
    }

    @RequestMapping(value="/trainings/params", method=RequestMethod.POST,
            consumes = "application/json")
    public List<Training> filterTraining(@RequestBody TrainingHelper trainingHelper){
        System.out.println(trainingService.filterTraining(trainingHelper));
        return trainingService.filterTraining(trainingHelper);
    }


    @RequestMapping(value = "/test", method=RequestMethod.GET, produces="application/json")
    public String test() {
        return "Test";
    }

}
