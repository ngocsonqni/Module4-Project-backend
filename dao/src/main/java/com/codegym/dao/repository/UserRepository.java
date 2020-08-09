package com.codegym.dao.repository;

import com.codegym.dao.entity.Employee;
import com.codegym.dao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findAllByDeleteFlagIsFalse(Pageable pageable);

    User findByAccount_AccountName(String accountName);

    //hieu tran add
    User findAllByDeleteFlagIsFalseAndAccount_AccountId(int accountId);

    //Huy add
    @Query(value = "select * " +
            "from user u " +
            "inner join order_user o " +
            "on u.id_user = o.id_user " +
            "where (u.birthday like ?1 or u.user_name like ?2 or u.phone like ?3 or u.email like ?4 and u.delete_flag = 0) " +
            "and o.order_date between ?5 and ?6  group by u.id_user", nativeQuery = true)
    Page<User> getAllUser(String name, String birthday, String phone, String email, String value1, String value2, Pageable page);
}
