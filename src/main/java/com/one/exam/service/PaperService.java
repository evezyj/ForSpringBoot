package com.one.exam.service;

import com.one.exam.model.PaperDetail;
import com.one.exam.model.SubjectInfo;

import java.util.List;

public interface PaperService {
    List<PaperDetail> getPaperList() throws Exception;

    SubjectInfo getSubjectInfo(int pdId) throws Exception;
}
