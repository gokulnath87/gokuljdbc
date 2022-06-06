package com.house.plan.service;


import com.house.plan.entity.HousePlan;
import com.house.plan.repo.PlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanImpl implements PlanInterface {


    @Autowired
    private PlanRepo planRepo;

    @Override
    public int save(HousePlan housePlan) {
        return planRepo.save(housePlan);
    }

    @Override
    public int update(HousePlan housePlan, int id) {
        return planRepo.update(housePlan,id);
    }

    @Override
    public int delete(int id) {
        return planRepo.delete(id);
    }

    @Override
    public List<HousePlan> getAll() {
        return planRepo.getAll();
    }

    @Override
    public HousePlan getById(int id) {
        return planRepo.getById(id);
    }
}
