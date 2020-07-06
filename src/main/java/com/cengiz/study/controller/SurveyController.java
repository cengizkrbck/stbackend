package com.cengiz.study.controller;

import com.cengiz.study.dto.QuestionDto;
import com.cengiz.study.dto.SurveyDto;
import com.cengiz.study.service.frontend.SurveyControllerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("${api.context.url}/survey")
@CrossOrigin(origins = {"*"})
public class SurveyController {

    @Autowired
    private SurveyControllerService surveyControllerService;

    @GetMapping
    public ResponseEntity<SurveyDto> getQuestions() {
        return new ResponseEntity(surveyControllerService.prepareSurvey(), HttpStatus.OK);
    }

    @PutMapping
    public void saveQuestions(@RequestBody SurveyDto surveyDto) {
        surveyControllerService.createQuestions(surveyDto);
    }



}
