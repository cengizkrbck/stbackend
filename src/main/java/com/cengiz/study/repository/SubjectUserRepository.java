package com.cengiz.study.repository;

import com.cengiz.study.entities.SubjectUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectUserRepository extends JpaRepository<SubjectUser, Long> {
}
