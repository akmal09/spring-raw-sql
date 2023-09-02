package com.raw.springsql.repository;

import com.raw.springsql.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AddressRepo extends JpaRepository<Address, Integer> {

    @Query(
            nativeQuery = true,
            value = "SELECT ea.id, ea.city, ea.state FROM spring_raw_sql.address ea join spring_raw_sql.employee e on e.id = ea.employee_id where ea.employee_id=:employeeId"
    )
    Optional<Address> findAddressByEmpoleeId(@Param("employeeId") int employeeId);
}
