package com.riwi.filtro.domain.entities;

import java.util.List;
import com.riwi.filtro.utils.enums.TypeQuestion;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Entity(name = "question")
public class Question {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Lob
  private String text;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private TypeQuestion type;

  @Column(nullable = false)
  private Boolean active;

  //relaciones survey id

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(
    name = "survey_id",
    referencedColumnName = "id"
  )
  private Survey survey;

  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "question",
  fetch = FetchType.LAZY,
  cascade = CascadeType.ALL,
  orphanRemoval = false
  )
  private List<OptionQuestion> optionQuestions;

}
