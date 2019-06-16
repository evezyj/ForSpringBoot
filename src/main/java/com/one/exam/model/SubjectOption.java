package com.one.exam.model;

import javax.persistence.*;

@Table(name="subjectoption")
@Entity
public class SubjectOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String answerDesccription;
    private String answerOption;

    private int psId;
    private boolean isTrue;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnswerDesccription() {
        return answerDesccription;
    }

    public void setAnswerDesccription(String answerDesccription) {
        this.answerDesccription = answerDesccription;
    }

    public String getAnswerOption() {
        return answerOption;
    }

    public void setAnswerOption(String answerOption) {
        this.answerOption = answerOption;
    }

    public int getPsId() {
        return psId;
    }

    public void setPsId(int psId) {
        this.psId = psId;
    }

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }
}
