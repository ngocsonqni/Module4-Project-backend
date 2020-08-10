package com.codegym.dao.repository;

import com.codegym.dao.entity.Bill;
import com.codegym.dao.entity.Distributor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Integer> {
    List<Bill> findAllByDeleteFlagFalse();
    List<Bill> findAllByIdDistributorAndShippingStatusIsNot(Distributor distributor, String status);
    @Query(value = "select b from Bill b where b.idDistributor.id =?1 and b.shippingStatus is not 'đã xử lý'")
    List<Bill>findAllBillByDistributorId(int id);
    Page<Bill> findAllByDeleteFlagFalse(Pageable pageable);

}
