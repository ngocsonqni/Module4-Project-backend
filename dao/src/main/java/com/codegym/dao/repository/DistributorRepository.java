package com.codegym.dao.repository;

import com.codegym.dao.entity.Distributor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DistributorRepository extends JpaRepository<Distributor, Integer> {

    Page<Distributor> findAllByNameContainingAndDeleted(Pageable pageable, String name, boolean deleted);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update Distributor u set u.deleted = ?1 where u.id = ?2")
    void delete(boolean isDeleted, Integer id);

    List<Distributor> findAllByDeleted(boolean isNotDeleted);

    Distributor findAllByNameAndIdIsNot(String name, int id);

    @Transactional
    @Query("select d from Distributor d where d.id=?1 and d.status= 0")
    Distributor findAllByIdAndStatusIs(int id);

    @Transactional
    @Modifying
    @Query("update Distributor d set d.status=?2 where d.id=?1")
    void setStatusDistributorById(int id, int status);

    @Transactional
    @Modifying
    @Query(value = "CREATE EVENT IF NOT EXISTS event:id ON SCHEDULE AT (CURRENT_TIMESTAMP + INTERVAL 30 SECOND ) DO UPDATE distributor SET distributor.status = 0 where" +
            " distributor.id_distributor = :id and distributor.status <> 0", nativeQuery = true)
    void setSessionDistributorById(@Param("id") int id);


    @Transactional
    @Modifying
    @Query(value = "DROP EVENT IF EXISTS event:id", nativeQuery = true)
    void removeSessionDistributorById(@Param("id") int id);


    Distributor findAllByIdAndStatusIsNot(int id, int status);

    @Transactional
    @Modifying
    @Query(value = "update Distributor d set d.numSession = d.numSession+1 where d.id = ?1")
    void increaseNumSessionById(int id);

    @Query(value = "select d.numSession from Distributor d where d.id = ?1")
    int getNumOfSessionById(int id);

@Query(value="select d from Distributor d where d.id=?1 and d.deleted=false")
    Distributor isNotDeletedById(int id);
}
