package com.one.exam.model;

import javax.persistence.*;
import java.util.List;

@Table(name="papersubject")
@Entity
public class PaperSubject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int pdId;
    private int subjectId;
    private String subjectName;
    @Transient
    private List<SubjectOption> subjectOptions;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPdId() {
        return pdId;
    }

    public void setPdId(int pdId) {
        this.pdId = pdId;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public List<SubjectOption> getSubjectOptions() {
        return subjectOptions;
    }

    public void setSubjectOptions(List<SubjectOption> subjectOptions) {
        this.subjectOptions = subjectOptions;
    }
}
