package com.chefshare.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.chefshare.model.Board;

//@Repository //생략가능
public interface BoardRepository extends JpaRepository<Board, Integer> {
	Page<Board> findByTitleContaining(String keyword, Pageable pageable);
}
