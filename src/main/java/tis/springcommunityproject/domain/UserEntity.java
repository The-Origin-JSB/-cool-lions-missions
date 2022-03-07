package tis.springcommunityproject.domain;

import lombok.Builder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Users")
public class UserEntity {

	@Id
	@GeneratedValue
	@Column(name = "user_id")
	private Long id;

	private String name;

	//TODO 등록일자와 수정일자는 공통으로 처리 가능하다.
	@Column(updatable = false)
	@CreatedDate
	private LocalDateTime createAt;

	@Column(insertable = false)
	@LastModifiedDate
	private LocalDateTime updateAt;

	protected UserEntity() {
	}

	private UserEntity(String name) {
		this(null, name, null, null);
	}

	private UserEntity(Long id, String name, LocalDateTime createAt, LocalDateTime updateAt) {
		this.id = id;
		this.name = name;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public static UserEntity of(Long id, String name, LocalDateTime createAt, LocalDateTime updateAt) {
		return new UserEntity(id, name, createAt, updateAt);
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}
}
