package com.cengiz.study.dto;

import com.cengiz.study.enums.QuestionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    @Getter
    @Setter
    private Integer order;

    @Getter
    @Setter
    private String category;

    @Getter
    @Setter
    private String label;

    @Getter
    @Setter
    private QuestionType questionType;

    @Getter
    @Setter
    private List<String> choices;

    @Getter
    @Setter
    private Integer rangeStart;

    @Getter
    @Setter
    private Integer rangeEnd;

    @Getter
    @Setter
    private Long id;
}
