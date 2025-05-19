package com.shawilTech.resumeanalyzer.repository;

import com.shawilTech.resumeanalyzer.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, String> {
}
