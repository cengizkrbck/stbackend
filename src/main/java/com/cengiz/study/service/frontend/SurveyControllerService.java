package com.cengiz.study.service.frontend;

import com.cengiz.study.dto.QuestionDto;
import com.cengiz.study.dto.SurveyDto;
import com.cengiz.study.entities.Question;
import com.cengiz.study.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SurveyControllerService {

    @Autowired
    private QuestionRepository questionRepository;


    public List<QuestionDto> getAllQuestions(){

        List<Question> questions = questionRepository.findAll();


        List<QuestionDto> result = new ArrayList<>();
        questions.forEach(question -> result.add(toDto(question)));
        return result;
    }

    public SurveyDto prepareSurvey() {
        return new SurveyDto(getAllQuestions());
    }

    public void createQuestions(SurveyDto surveyDto) {
        surveyDto.getQuestions().forEach(questionDto -> questionRepository.save(fromDto(questionDto)));
    }

    private Question fromDto(QuestionDto dto) {
        Question entity = new Question();
        entity.setOrder(dto.getOrder());
        entity.setCategory(dto.getCategory());
        entity.setLabel(dto.getLabel());
        entity.setQuestionType(dto.getQuestionType());
        entity.setChoices(dto.getChoices());
        entity.setRangeStart(dto.getRangeStart());
        entity.setRangeEnd(dto.getRangeEnd());
        return entity;
    }

    private QuestionDto toDto(Question question) {
        return new QuestionDto(
                question.getOrder(),
                question.getCategory(),
                question.getLabel(),
                question.getQuestionType(),
                question.getChoices(),
                question.getRangeStart(),
                question.getRangeEnd(),
                question.getId()
        );

    }


}
