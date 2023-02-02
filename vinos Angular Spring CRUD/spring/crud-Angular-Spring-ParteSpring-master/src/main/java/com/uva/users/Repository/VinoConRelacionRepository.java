package com.uva.users.Repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.uva.users.Model.VinoConRelacion;

public interface VinoConRelacionRepository extends JpaRepository<VinoConRelacion, Integer> {
    

}
