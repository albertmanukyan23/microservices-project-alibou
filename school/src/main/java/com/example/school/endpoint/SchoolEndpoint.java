package com.example.school.endpoint;


import com.example.school.entity.FullSchoolResponse;
import com.example.school.entity.School;
import com.example.school.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/schools")
@RequiredArgsConstructor
public class SchoolEndpoint {

    private final SchoolService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody School school) {
        studentService.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> getSchools() {
        return ResponseEntity.ok(studentService.findAllSchools());
    }

    @GetMapping("/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> getSchools(@PathVariable("school-id") Integer schoolId) {
        return ResponseEntity.ok(studentService.findSchoolsWithStudents(schoolId));
    }
}
