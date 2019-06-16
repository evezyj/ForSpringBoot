package com.one.exam.repo;

import com.one.exam.model.PaperSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PaperSubjectRepository extends JpaRepository<PaperSubject,PaperSubject> {
    List<PaperSubject> findByPdId(int pd_id);
}
