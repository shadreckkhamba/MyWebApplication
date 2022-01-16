package com.example.demo.MyWebApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ApplicationService<myWebApplication> { final private ApplicationRepository applicationRepository;
@Autowired
    public ApplicationService(ApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }
    public List<MyWebApplication> getApplications(){
        return applicationRepository.findAll();
    }

    public void addApplication(MyWebApplication myWebApplication) {
        Optional<MyWebApplication> myWebApplicationOptional = applicationRepository
                .findMyWebApplicationByName(myWebApplication.getName());
    if(myWebApplicationOptional.isPresent()){
        throw new IllegalStateException("Application is available for download");
    }else
        throw new IllegalStateException("Application package not available on this website");
    }
    public void deleteMyWebApplication(Long myWebApplicationId) {
    boolean exists = applicationRepository.existsById(myWebApplicationId);
    if (!exists){
        throw new IllegalStateException("The application package with Id " + myWebApplicationId+" is not found");
    }
    applicationRepository.deleteById(myWebApplicationId);
    }
     @Transactional
    public void updatemyWebApplication(Long myWebApplicationId, String name, String email) {
    MyWebApplication myWebApplication = applicationRepository.findById(myWebApplicationId)
            .orElseThrow(() -> new IllegalStateException("Opps! The application package does not exist in here"));
     if(name !=null && name.length()>0 && !Objects.equals(myWebApplication.getName(), name)){
         myWebApplication.setName(name);
      }
         if(email !=null && email.length() > 0 && !Objects.equals(myWebApplication.getEmail(), email)){
         Optional<myWebApplication>myWebApplicationOptional= applicationRepository.findMyWebApplicationByEmail(email);
         if(myWebApplicationOptional.isPresent()){
             throw new IllegalStateException("Email is taken, Try a Different one");
         }
         myWebApplication.setEmail(email);
     }
    }
}
