package com.cengiz.study.service.frontend;


import com.cengiz.study.dto.SurveyResultDto;
import com.cengiz.study.entities.Answer;
import com.cengiz.study.entities.SubjectUser;
import com.cengiz.study.repository.AnswerRepository;
import com.cengiz.study.repository.SubjectUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultsControllerService {
    @Autowired
    private SubjectUserRepository subjectUserRepository;

    @Autowired
    private AnswerRepository answerRepository;


    public SurveyResultDto getUserAnswers(String nickname) {
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
