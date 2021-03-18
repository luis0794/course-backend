package com.ltobar.course.controller;


import com.ltobar.course.common.vo.request.RegisterInstructorReqVO;
import com.ltobar.course.common.vo.request.UpdateInstructorReqVO;
import com.ltobar.course.model.Instructor;
import com.ltobar.course.services.impl.InstructorServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/instructor")
public class InstructorController {

    @Resource
    private InstructorServiceImpl service;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/findAll")
    List<Instructor> findAll() {
        return this.service.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/findById")
    Instructor findById(@RequestParam Integer id) {
        return this.service.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/createInstructor")
    public Instructor createInstructor(@RequestBody RegisterInstructorReqVO request) {
        return this.service.createInstructor(request);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/updateInstructor")
    public void updateInstructor(@RequestBody UpdateInstructorReqVO request) {
        this.service.updateInstructor(request);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteInstructor")
    public void deleteInstructor(@RequestParam Integer id) {
        this.service.deleteInstructor(id);
    }
}
