package com.prady00.question;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prady00.answer.Answer;

@Entity
@Table(name = "questions")
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, 
allowGetters = true)
@EntityListeners(AuditingEntityListener.class)
public class Question implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String description;
	
	@Column(nullable = false, updatable = false)
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdAt;
	
	@Column(nullable = false)
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	
	
	private Answer answers;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    
    @OneToOne(mappedBy = "getQuestions")
	public Answer getAnswers() {
		return answers;
	}

}
