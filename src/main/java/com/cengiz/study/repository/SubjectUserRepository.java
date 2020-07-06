package com.cengiz.study.repository;

import com.cengiz.study.entities.SubjectUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectUserRepository extends JpaRepository<SubjectUser, Long> {
    Optional<SubjectUser> findByNickname(String nickname);
}
