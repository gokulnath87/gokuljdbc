package com.house.plan.repo;


import com.house.plan.entity.HousePlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int save(HousePlan housePlan){
   return   jdbcTemplate.update("INSERT INTO tbl_plans (name,email,dept)VALUES(?,?,?)",new Object[] {housePlan.getName(),housePlan.getEmail(),housePlan.getDept()});

    }
    public List<HousePlan>getAll(){
       // return jdbcTemplate.query("SELECT * FROM tbl_plans",new BeanPropertyRowMapper<HousePlan>(HousePlan.class));
        return jdbcTemplate.query("SELECT * FROM tbl_plans",new BeanPropertyRowMapper<HousePlan>(HousePlan.class));
    }
    public HousePlan getById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM tbl_plans where id =?",new BeanPropertyRowMapper<>(HousePlan.class),id);
//        String sql ="select from tbl_plans where id = ?";
//        int rate = jdbcTemplate.update(sql,id);
//        return "Deleted successfully";

    }
    public int update(HousePlan housePlan,int id){
       return jdbcTemplate.update("UPDATE tbl_plans SET name=?,email=?,dept=? WHERE id=?",new Object[]{housePlan.getName(),housePlan.getDept(),housePlan.getEmail(),id} );

    }
    public int delete(int id){
        return jdbcTemplate.update("DELETE FROM tbl_plans WHERE id =?",id);
    }
}
