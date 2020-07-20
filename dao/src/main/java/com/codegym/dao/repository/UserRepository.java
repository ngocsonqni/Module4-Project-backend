package com.codegym.dao.repository;

import com.codegym.dao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "SELECT code_bakery.user.*  FROM code_bakery.user  WHERE UPPER(user_name) LIKE CONCAT('%', CONCAT(UPPER(:search), '%')) AND delete_flag is false",
            countQuery = "SELECT sum(total_money) as total FROM code_bakery.order_user group by id_user " ,
            nativeQuery = true)
    Page<User> getAllUser(@Param("search")String search, Pageable pageable);
    User findByAccount_AccountName(String accountName);
}
