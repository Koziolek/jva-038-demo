package com.luxoft.demoide;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
interface CompanyRepository extends JpaRepository<Company, Long> {
}
