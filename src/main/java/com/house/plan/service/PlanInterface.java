package com.house.plan.service;

import com.house.plan.entity.HousePlan;

import java.util.List;

public interface PlanInterface {
    int save(HousePlan housePlan);
    int update(HousePlan housePlan,int id);
    int delete(int id);
    List<HousePlan> getAll();
    HousePlan getById(int id);
}
