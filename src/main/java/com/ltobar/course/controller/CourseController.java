package com.ltobar.course.controller;


import com.ltobar.course.common.vo.request.RegisterCourseReqVO;
import com.ltobar.course.common.vo.request.UpdateCourseReqVO;
import com.ltobar.course.model.Course;
import com.ltobar.course.services.CourseService;
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
@RequestMapping("/api/course")
public class CourseController {

    @Resource
    private CourseService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/findAll")
    List<Course> findAll() {
        return this.service.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/findById")
    Course findById(@RequestParam Integer id) {
        return this.service.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/createCourse")
    public Course createCourse(@RequestBody RegisterCourseReqVO request) {
        return this.service.createCourse(request);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/updateCourse")
    public void updateCourse(@RequestBody UpdateCourseReqVO request) {
        this.service.updateCourse(request);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteCourse")
    public void deleteCourse(@RequestParam Integer id) {
        this.service.deleteCourse(id);
    }
}
