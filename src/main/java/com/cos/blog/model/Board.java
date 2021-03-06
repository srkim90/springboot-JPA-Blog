package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량
	private String content;
	
	@ColumnDefault("0") 
	private int count;
	
	@ManyToOne(fetch = FetchType.EAGER) // Many = board, User = One 
	@JoinTable(name="userId")
	private User user ;//DB는 오브젝트를 저장 할 수 없지만 ORM에서는 그게 가능 하데요
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // mappedBy가 있으면 연관관계의 주인이 아니다. (FK 가 아니에요~)
	//@JoinTable(name="replyId")
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
	
}
