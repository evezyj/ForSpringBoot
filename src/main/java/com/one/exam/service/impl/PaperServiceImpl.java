package com.one.exam.service.impl;

import com.one.exam.model.PaperDetail;
import com.one.exam.model.PaperSubject;
import com.one.exam.model.SubjectInfo;
import com.one.exam.model.SubjectOption;
import com.one.exam.repo.PaperRepository;
import com.one.exam.repo.PaperSubjectRepository;
import com.one.exam.repo.SubjectOptionRepository;
import com.one.exam.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
public class PaperServiceImpl implements PaperService {

    @Autowired
    PaperRepository paperRepository;

    @Autowired
    PaperSubjectRepository paperSubjectRepository;

    @Autowired
    SubjectOptionRepository subjectOptionRepository;

    @Override
    public List<PaperDetail> getPaperList() throws Exception {
        return paperRepository.findAll();
    }

    @Override
    public SubjectInfo getSubjectInfo(int pdId) throws Exception {
        SubjectInfo subjectInfo = new SubjectInfo();
        List<SubjectOption> subjectOptions = null;
        List<PaperSubject> paperSubjects = null;
        List<PaperSubject> paperSubjectList = new ArrayList<PaperSubject>();
        paperSubjects = paperSubjectRepository.findByPdId(pdId);
        PaperDetail paperDetail = paperRepository.findById(paperSubjects.get(0).getPdId());
        subjectInfo.setPaperDetail(paperDetail);
        for (PaperSubject paperSubject : paperSubjects) {
            PaperSubject subject = new PaperSubject();
            subjectOptions = subjectOptionRepository.findByPsId(paperSubject.getId());
            subject.setId(paperSubject.getId());
            subject.setPdId(paperSubject.getPdId());
            subject.setSubjectId(paperSubject.getSubjectId());
            subject.setSubjectName(paperSubject.getSubjectName());
            subject.setSubjectOptions(subjectOptions);
            paperSubjectList.add(subject);
        }
        Collections.sort(paperSubjectList, new Comparator<PaperSubject>() {
            @Override
            public int compare(PaperSubject u1, PaperSubject u2) {
                int diff = u1.getSubjectId() - u2.getSubjectId();
                if (diff > 0) {
                    return 1;
                }else if (diff < 0) {
                    return -1;
                }
                return 0;
            }
        });
        subjectInfo.setPaperSubjects(paperSubjectList);
        return subjectInfo;
    }
}
