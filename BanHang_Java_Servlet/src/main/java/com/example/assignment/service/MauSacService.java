package com.example.assignment.service;

import com.example.assignment.dto.MauSacDTO;
import com.example.assignment.entity.MauSac;
import com.example.assignment.entity.NSX;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MauSacService {
    List<MauSacDTO> getAll();
}
