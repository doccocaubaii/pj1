package edu.hust.project1.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "xe", schema = "project1")
public class XeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = true, length = 50)
    private String name;
    @Basic
    @Column(name = "price", nullable = true)
    private Integer price;
    @Basic
    @Column(name = "bien_so", nullable = true, length = 50)
    private String bienSo;
    @Basic
    @Column(name = "status", nullable = true)
    private Boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_dai_ly", referencedColumnName = "id")
    @ToString.Exclude
    private DaiLyEntity daiLyByIdDaiLy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        XeEntity xeEntity = (XeEntity) o;
        return Objects.equals(id, xeEntity.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
