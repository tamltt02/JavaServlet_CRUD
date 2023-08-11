package com.example.assignment.reponsitory;

import com.example.assignment.entity.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSacRepository  extends JpaRepository<MauSac,Integer> {
}
