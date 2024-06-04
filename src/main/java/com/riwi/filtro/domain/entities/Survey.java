package com.riwi.filtro.domain.entities;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "survey")
public class Survey {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 255)
  private String title;

  @Lob
  private String description;

  @CreationTimestamp
  @Column(nullable = false)
  private LocalDate creationDate;

  @Column(nullable = false)
  private Boolean active;

  //relaciones creator_id
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
    name = "creator_id",
    referencedColumnName = "id"
  )
  private User creator;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "survey",
  fetch = FetchType.LAZY,
  cascade = CascadeType.ALL,
  orphanRemoval = false
  )
  private List<Question> questions;
}

