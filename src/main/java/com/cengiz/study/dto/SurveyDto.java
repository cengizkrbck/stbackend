package com.cengiz.study.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class SurveyDto {

    @Getter
    @Setter
    private List<QuestionDto> questions;
}
