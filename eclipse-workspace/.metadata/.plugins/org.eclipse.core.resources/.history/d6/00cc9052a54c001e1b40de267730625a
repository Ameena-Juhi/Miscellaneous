package com.prodapt.learningspring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Entity
@Data
public class Comment{
	
	private String content;
  

@Column(unique=true)
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private int id;
  
  @EmbeddedId
  private CommentId commentId;
  
  public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

  public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

  public CommentId getCommentId() {
	  return commentId;
  }

  public void setCommentId(CommentId commentId) {
	  this.commentId = commentId;
  }
  
}