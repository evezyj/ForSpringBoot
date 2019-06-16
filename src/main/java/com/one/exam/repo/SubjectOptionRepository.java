package com.one.exam.repo;

import com.one.exam.model.SubjectOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SubjectOptionRepository extends JpaRepository<SubjectOption,SubjectOption> {

    List<SubjectOption> findByPsId(int ps_id);
}
