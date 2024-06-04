package com.riwi.filtro.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "opyionQuestion")
public class OptionQuestion {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Lob
  private String text;

  @Column(nullable = false)
  private Boolean active;

  //realciones question_id

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
    name = "question_id",
    referencedColumnName = "id"
  )
  private Question question;
}
