package com.chefshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chefshare.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {
	
//	@Modifying
//	@Query(value = "INSERT INTO reply(userId, boardId, content, createDate) VALUES(?1, ?2, ?3, now()", nativeQuery = true)
//	int mSave(int userId, int boardId, String content);
}
