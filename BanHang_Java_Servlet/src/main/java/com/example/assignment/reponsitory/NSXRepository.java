package com.example.assignment.reponsitory;

import com.example.assignment.entity.NSX;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NSXRepository  extends JpaRepository<NSX,Integer> {
}
