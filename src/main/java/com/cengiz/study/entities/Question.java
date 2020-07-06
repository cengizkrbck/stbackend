package com.cengiz.study.entities;

import com.cengiz.study.enums.QuestionType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
public class Question extends AuditModel{

    @Getter
    @Setter
    @Id
    @GeneratedValue
    private Long id;

    @Getter
    @Setter
    @Column(name = "ordr")
    private Integer order;

    @Getter
    @Setter
    private String category;

    @Getter
    @Setter
    private String label;

    @Getter
    @Setter
    @Column(name = "question_type")
    @Enumerated(EnumType.STRING)
    private QuestionType questionType;

    @Getter
    @Setter
    @ElementCollection
    private List<String> choices;

    @Getter
    @Setter
    @Column(name = "range_start")
    private Integer rangeStart;

    @Getter
    @Setter
    @Column(name = "range_end")
    private Integer rangeEnd;



}
