package com.one.exam.repo;

import com.one.exam.model.PaperDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperRepository extends JpaRepository<PaperDetail, PaperDetail> {

    PaperDetail findById(int id);
}
