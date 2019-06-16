package com.one.exam.repo;

import com.one.exam.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo,UserInfo> {

    List<UserInfo> findById(int id);
}
