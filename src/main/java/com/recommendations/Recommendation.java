package com.recommendations;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recommendation {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String author;
	private String relation;
	private String recEntry;
	
	public Recommendation() {
		
	}
	
	public Recommendation(String author, String relation, String recEntry) {
		this.author = author;
		this.relation = relation;
		this.recEntry = recEntry;
	}
	
	@Override
	public String toString() {
		return "Recommendation [id=" + id + ", author=" + author + ", relation=" + relation + ", recEntry=" + recEntry
				+ "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public String getRecEntry() {
		return recEntry;
	}

	public void setRecEntry(String recEntry) {
		this.recEntry = recEntry;
	}
	
}