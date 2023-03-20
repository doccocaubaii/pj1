package edu.hust.project1.repository;

import edu.hust.project1.entity.DaiLyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaiLyRepository extends JpaRepository<DaiLyEntity, Integer> {
    List<DaiLyEntity> findAllByIsActive(Integer isActive);
    DaiLyEntity findByIdAndIsActive(Integer id, Integer isActive);
}
