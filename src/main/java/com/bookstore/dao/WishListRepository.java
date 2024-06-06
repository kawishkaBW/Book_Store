package com.bookstore.dao;

import com.bookstore.model.WishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishListRepository extends JpaRepository<WishList,Long>{
	WishList findBySessionToken(String sessionToken);
}
