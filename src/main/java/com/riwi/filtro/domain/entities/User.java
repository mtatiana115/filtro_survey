package com.riwi.filtro.domain.entities;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Entity(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(nullable = false, length = 255)
  private String password;
  
  @Column(nullable = false, length = 100)
  private String email;

  @Column(nullable = false)
  private Boolean active;

  //Relaciones
  @ToString.Exclude
  @EqualsAndHashCode.Exclude
  @OneToMany(mappedBy = "user",
  fetch = FetchType.LAZY,
  cascade = CascadeType.ALL,
  orphanRemoval = false
  )
  private List<Survey> surveys;
}

