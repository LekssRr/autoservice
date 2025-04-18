package ru.autoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.autoservice.entity.AutoEntity;

@Repository
public interface AutoRepository extends JpaRepository<AutoEntity, String> {
}
