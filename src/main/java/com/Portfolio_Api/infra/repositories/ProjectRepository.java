package com.Portfolio_Api.infra.repositories;

import com.Portfolio_Api.domain.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer>{
}
