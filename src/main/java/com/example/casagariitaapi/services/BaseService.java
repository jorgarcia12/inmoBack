package com.example.casagariitaapi.services;

import com.example.casagariitaapi.models.BaseModel;
import com.example.casagariitaapi.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public abstract class BaseService<E extends BaseModel> {

    protected BaseRepository<E, Long> repository;

    @Autowired
    public BaseService(BaseRepository<E, Long> repository) {
        this.repository = repository;
    }

    public List<E> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    public E save(E entity) {
        return repository.save(entity);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
