package com.example.casagariitaapi.repositories;

import com.example.casagariitaapi.models.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface BaseRepository<E extends BaseModel, ID extends Serializable> extends JpaRepository<E, ID> {
}
