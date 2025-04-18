package ru.autoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.autoservice.entity.ServiceCompanyEntity;

@Repository
public interface ServiceCompanyRepository extends JpaRepository<ServiceCompanyEntity, String> {
}
