package com.cengiz.study.service.frontend;


import com.cengiz.study.dto.AnswerDto;
import com.cengiz.study.dto.SurveyResultDto;
import com.cengiz.study.entities.Answer;
import com.cengiz.study.entities.SubjectUser;
import com.cengiz.study.repository.AnswerRepository;
import com.cengiz.study.repository.SubjectUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ResultsControllerService {
    @Autowired
    private SubjectUserRepository subjectUserRepository;

    @Autowired
    private AnswerRepository answerRepository;


    public SurveyResultDto getUserAnswers(String nickname) {
        SurveyResultDto dto = new SurveyResultDto();
        dto.setNickname(nickname);

        List<AnswerDto> result = new ArrayList<>();
        Optional<SubjectUser> user = subjectUserRepository.findByNickname(nickname);
        if (!user.isPresent()){
            return dto;
        }

        user.get().getAnswers().forEach(answer -> result.add(toDto(answer)));

        dto.setAnswers(result);

        return dto;
    }

    private AnswerDto toDto(Answer answer) {
        AnswerDto dto = new AnswerDto();
        dto.setQuestion(answer.getQuestion());
        dto.setResult(answer.getResult());

        return null;
    }

    public void saveUserAnswers(SurveyResultDto dto) {
        SubjectUser user = new SubjectUser();
        user.setNickname(dto.getNickname());
        subjectUserRepository.save(user);


        dto.getAnswers().forEach(answerDto -> {
            Answer answer = new Answer();
            answer.setUser(user);
            answer.setQuestion(answerDto.getQuestion());
            answer.setResult(answerDto.getResult());
            answerRepository.save(answer);
            user.getAnswers().add(answer);
        });

        subjectUserRepository.save(user);
    }
}
