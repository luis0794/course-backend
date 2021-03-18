package com.ltobar.course.controller;


import com.ltobar.course.common.vo.request.RegisterSchoolYearReqVO;
import com.ltobar.course.common.vo.request.UpdateSchoolYearReqVO;
import com.ltobar.course.common.vo.response.SchoolYearVO;
import com.ltobar.course.model.SchoolYear;
import com.ltobar.course.services.SchoolYearService;
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
@RequestMapping("/api/schoolYear")
public class SchoolYearController {

    @Resource
    private SchoolYearService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/findAll")
    List<SchoolYearVO> findAll() {
        return this.service.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/findById")
    SchoolYearVO findById(@RequestParam Integer id) {
        return this.service.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/createSchoolYear")
    public SchoolYear createSchoolYear(@RequestBody RegisterSchoolYearReqVO request) {
        return this.service.createSchoolYear(request);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/updateSchoolYear")
    public void updateSchoolYear(@RequestBody UpdateSchoolYearReqVO request) {
        this.service.updateSchoolYear(request);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/deleteSchoolYear")
    public void deleteSchoolYear(@RequestParam Integer id) {
        this.service.deleteSchoolYear(id);
    }
}
