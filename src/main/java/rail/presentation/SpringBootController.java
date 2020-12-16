package rail.presentation;

import rail.domain.Train;
import rail.domain.TrainComponent;
import rail.parser.controllers.TrainAdministratorController;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//@RestController
public class SpringBootController {

    public TrainAdministratorController trainAdministratorController = new TrainAdministratorController();

    @GetMapping()
    public String GetCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

//    @RequestMapping(value = "/{naam}", method = RequestMethod.PUT)
//    public String DisplayName(@PathVariable("naam") String naam){
//        return "Hello " + naam;
//    }

//    @RequestMapping(value = "/home")
//    public String index(){
//        return "index.html";
//    }

    @RequestMapping(value="/home", method=RequestMethod.GET)
    @ResponseBody
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView("index.html");
        return mv;
    }

    @GetMapping(value = "/alltrains")
    public List<Train> getAllTrains(){
        return trainAdministratorController.giveAllTrains();
    }

    @GetMapping(value = "/alltraincomponents")
    public List<TrainComponent> getTrainComponents(){return trainAdministratorController.allTrainComponents();}

    @RequestMapping(value = "/bais.js")
    @ResponseBody
    public ModelAndView dynamicJS() {
        ModelAndView mv = new ModelAndView("bais.js");
        return mv;
    }

}