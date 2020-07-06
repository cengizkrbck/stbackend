package com.cengiz.study.controller;

import com.cengiz.study.dto.SurveyResultDto;
import com.cengiz.study.service.frontend.ResultsControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("${api.context.url}/results")
@CrossOrigin(origins = {"*"})
public class ResultsController {

    @Autowired
    private ResultsControllerService resultsControllerService;

    @GetMapping("/{nickname}")
    public ResponseEntity<SurveyResultDto> getResults(@PathVariable("nickname") String nickname){
        return new ResponseEntity(resultsControllerService.getUserAnswers(nickname), HttpStatus.OK);
    }

    @PutMapping
    public void saveUserResults(@RequestBody SurveyResultDto dto){
        resultsControllerService.saveUserAnswers(dto);
    }

}
