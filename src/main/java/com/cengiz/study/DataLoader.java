package com.cengiz.study;


import com.cengiz.study.entities.Question;
import com.cengiz.study.enums.QuestionType;
import com.cengiz.study.repository.QuestionRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataLoader {


    private QuestionRepository questionRepository;

    public DataLoader(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public void createData() {
        createQuestions();
    }


    private void createQuestions() {
        String c1 = "hard_fact";
        String c2 = "lifestyle";
        String c3 = "introversion";
        String c4 = "passion";



        Question q = new Question();
        q.setLabel("What is your gender?");
        q.setQuestionType(QuestionType.SINGlE_CHOICE);
        q.setChoices(Arrays.asList(
                "male",
                "female",
                "other"));
        questionRepository.save(q);

        Question q2 = new Question();
        q2.setCategory(c1);
        q2.setLabel("How important is the gender of your partner?");
        q2.setQuestionType(QuestionType.SINGlE_CHOICE);
        q2.setChoices(Arrays.asList(
                "not important",
                "very important",
                "important"));
        questionRepository.save(q2);

        Question q3 = new Question();
        q2.setCategory(c1);
        q2.setLabel("How important is the gender of your partner?");
        q2.setQuestionType(QuestionType.SINGlE_CHOICE);
        q2.setChoices(Arrays.asList(
                "not important",
                "very important",
                "important"));
        questionRepository.save(q2);

    }
}