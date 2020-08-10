package com.codegym.dao.repository;

import com.codegym.dao.entity.Distributor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface DistributorRepository extends JpaRepository<Distributor, Integer> {

    Page<Distributor> findAllByNameContainingAndDeleted(Pageable pageable, String name, boolean deleted);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Distributor u set u.deleted = ?1 where u.id = ?2")
    void delete(boolean isDeleted, Integer id);

    List<Distributor> findAllByDeleted(boolean isNotDeleted);

    Distributor findAllByNameAndIdIsNot(String name, int id);


    @Modifying
    @Transactional
    @Query("select d from Distributor d where d.id = :id and d.status <> 0 ")
    Distributor findByIdToDo(@Param("id") int id);

    @Transactional
    @Modifying
    @Query("update Distributor d set d.status = :status where d.id = :id")
    void setStatus(@Param("id") int id, @Param("status") int status);


    @Transactional
    @Modifying
    @Query(value = "DROP EVENT IF EXISTS event:id", nativeQuery = true)
    void dropEventById(@Param("id") int id);


    @Modifying
    @Transactional
    @Query(value = "CREATE EVENT IF NOT EXISTS event:id ON SCHEDULE AT (CURRENT_TIMESTAMP + INTERVAL 300 SECOND ) DO UPDATE distributor SET distributor.status = 0 where" +
            " distributor.id_distributor = :id and distributor.status <> 0", nativeQuery = true)
    public void resetStatus2(@Param("id") int id );



    public Distributor findByIdAndStatusIsAndDeletedIs(int id, int status, boolean deleted);

}
