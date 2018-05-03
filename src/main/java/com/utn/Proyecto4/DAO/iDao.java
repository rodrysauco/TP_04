package com.utn.Proyecto4.DAO;

import com.utn.Proyecto4.Models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface iDao extends JpaRepository <Cliente,Long> {

}
