package com.one.exam.controller;

import com.one.exam.model.PaperDetail;
import com.one.exam.model.SubjectInfo;
import com.one.exam.service.PaperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetPaperListController {
    @Autowired
    PaperService paperService;

    Logger log = LoggerFactory.getLogger(GetPaperListController.class);

    @RequestMapping("/getPaperList")
    public List<PaperDetail> getPaperList() {
        log.debug("Start GetPaperListController getPaperList");
        List<PaperDetail> paperDetails = null;
        try {
            paperDetails = paperService.getPaperList();
            log.debug("getPaperList paperDetails: " + paperDetails.toString());
        } catch (Exception e) {
            log.error("Exception in method getPaperList:" + e.getMessage());
        }
        return paperDetails;
    }

    @RequestMapping("/getPaperSubjects")
    public SubjectInfo getPaperSubjects(@RequestParam("pdId") int id) {
        log.debug("Start GetPaperListController getPaperSubjects pdId: " + id);
        SubjectInfo subjectInfo = null;
        try {
            subjectInfo = paperService.getSubjectInfo(id);
            log.debug("getPaperSubjects subjectInfo: " + subjectInfo.toString());
        } catch (Exception e) {
            log.error("Exception in method getPaperSubjects: " + e.getMessage());
        }
        return subjectInfo;
    }
}
