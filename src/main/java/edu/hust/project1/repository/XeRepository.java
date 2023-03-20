package edu.hust.project1.repository;

import edu.hust.project1.entity.XeEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface XeRepository extends JpaRepository<XeEntity, Integer> {
    List<XeEntity> findAllByStatus(Boolean status);
    XeEntity findByIdAndStatus(Integer id, Boolean status);

    @Query(value = "SELECT * FROM xe WHERE id_dai_ly = ?1 AND `status` = ?2", nativeQuery = true)
    List<XeEntity> queryWithIdDaiLyAndStatus(int idDaily, Integer status);
}
