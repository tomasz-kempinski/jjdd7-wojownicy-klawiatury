package com.infoshareacademy.wojownicy.domain.view;

public class AuthorLiveSearchView {

  private Long authorId;
  private String authorName;

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public Long getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Long authorId) {
    this.authorId = authorId;
  }
}
