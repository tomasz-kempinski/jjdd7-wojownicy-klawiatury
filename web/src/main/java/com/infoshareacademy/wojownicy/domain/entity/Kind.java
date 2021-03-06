package com.infoshareacademy.wojownicy.domain.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamedQueries({
    @NamedQuery(
        name = "Kind.findKindsList",
        query = "SELECT k FROM Kind k"
    ),
    @NamedQuery(
        name = "Kind.findKindByName",
        query = "SELECT k FROM Kind k WHERE k.kind = :kind"
    )
}
)
@Entity
@Table(name = "kind", indexes = {
    @Index(columnList = "kind", name = "kind_index")
})
public class Kind {

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long kindId;

  @NotNull
  @Column(name = "kind")
  private String kind;

  @OneToMany(mappedBy = "kind")
  private List<Book> books = new ArrayList<>();

  public Long getKindId() {
    return kindId;
  }

  public void setKindId(Long kindId) {
    this.kindId = kindId;
  }

  public String getKind() {
    return kind;
  }

  public void setKind(String kind) {
    this.kind = kind;
  }
}
