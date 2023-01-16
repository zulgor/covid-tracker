package com.coforge.main.service;

import com.coforge.main.dao.Dao;
import com.coforge.main.dao.Dao1;
import com.coforge.main.entities.Entity;
import com.coforge.main.entities.perDetails;
import com.coforge.main.helper.ExcelHelper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Dao empDao;
    @Autowired
    private Dao1 empDao1;

    public Optional<Entity> getEntity(int ecode){
        return empDao.findById(ecode);
    }
    public Entity save(Entity entity){
        return empDao.save(entity);
    }

    public perDetails savePer(int ecode, perDetails perdetails) {
        perdetails.setEcod(ecode);
        return empDao1.save(perdetails);
    }

    public Optional<perDetails> getEntities(int ecode) {
        return empDao1.findById(ecode);
    }

    public ByteArrayInputStream load(String ou,String sl) {
        List<Entity> entities = empDao.findByOuAndService_line(ou,sl);

        ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(entities);
        return in;
    }
    public ByteArrayInputStream load(String ou) {
        List<Entity> entities = empDao.findByOu(ou);

        ByteArrayInputStream in = ExcelHelper.tutorialsToExcel(entities);
        return in;
    }

}
