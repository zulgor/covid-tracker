package com.coforge.main.controller;

import com.coforge.main.entities.Entity;
import com.coforge.main.entities.perDetails;
import com.coforge.main.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class Controller {
    @Autowired
    private Service service;

    @GetMapping("/{ecode}")
    public Optional<Entity> getEmployees(@PathVariable int ecode) {
        return this.service.getEntity(ecode);
    }

    @GetMapping("/update/{ecode}")
    public Optional<perDetails> getEmployee(@PathVariable int ecode) {
        return this.service.getEntities(ecode);
    }

    @PostMapping("/add")
    public Entity addEmp(@RequestBody Entity entity){
        return this.service.save(entity);
    }


    @PutMapping("/{ecode}")
    public perDetails addPer(@PathVariable int ecode,@RequestBody perDetails perdetails){
        return this.service.savePer(ecode,perdetails);
    }
    @GetMapping("/download/{ou}/{sl}")
    public ResponseEntity<Resource> getFile(@PathVariable String ou,@PathVariable String sl) {
        String filename = "entities.xlsx";
        InputStreamResource file = new InputStreamResource(service.load(ou,sl));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

    @GetMapping("/download/{ou}")
    public ResponseEntity<Resource> getFile(@PathVariable String ou) {
        String filename = "entities.xlsx";
        InputStreamResource file = new InputStreamResource(service.load(ou));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
                .body(file);
    }

}
