package com.example.demo.MyWebApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1/applications")
public class ApplicationController {
    private final ApplicationService applicationService;
    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping
    public List<MyWebApplication> getApplications(){
        return applicationService.getApplications();
    }
    @PostMapping
    public void uploadNewMyWebApplication(@RequestBody MyWebApplication myWebApplication){
        applicationService.addApplication(myWebApplication);
    }
    @DeleteMapping(path="{myWebApplicationId}")
    public void deleteMyWebApplication(@PathVariable("myWebApplicationId")Long myWebApplicationId){
        applicationService.deleteMyWebApplication(myWebApplicationId);
    }
    @PutMapping(path = "{myWebApplicationId}")
    public void updatemyWebApplication(
            @PathVariable("myWebApplicationId") Long myWebApplicationId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email ) {
        applicationService.updatemyWebApplication(myWebApplicationId, name, email);
    }
}
