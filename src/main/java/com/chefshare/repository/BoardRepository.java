package com.chefshare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chefshare.model.Board;

//@Repository //��������
public interface BoardRepository extends JpaRepository<Board, Integer> {

}
