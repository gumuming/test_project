package com.gumm.project.test.repo;

import com.gumm.project.test.entity.AuthorDonor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorDonorRepo extends JpaRepository<AuthorDonor,String> {
}
