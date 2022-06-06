package com.house.plan.controller;

import com.house.plan.entity.HousePlan;
import com.house.plan.service.PlanInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {

    @Autowired
    private PlanInterface planInterface;

    @PostMapping("/savehouse")
    public String saveHouse(@RequestBody HousePlan housePlan){
       return planInterface.save(housePlan)+"no od rows are created";

    }
    @GetMapping("/houseplan")
    public List<HousePlan> getHouse(){
        return planInterface.getAll();
    }
    @GetMapping("/houseplan/{id}")
    public HousePlan getHousePlan(@PathVariable("id") int id){
        return planInterface.getById(id);
    }
    @PutMapping("/houseplan/{id}")
    public String updateHouse(@RequestBody HousePlan housePlan,@PathVariable("id") int id){
        return planInterface.update(housePlan,id)+"no of rows";
    }
    @DeleteMapping("/houseplan/{id}")
    public String deleteHousePlan(@PathVariable int id){
        return planInterface.delete(id)+"no of rows";
    }

}
