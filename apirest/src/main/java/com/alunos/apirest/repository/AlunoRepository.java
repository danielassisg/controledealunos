package com.alunos.apirest.repository;

import com.alunos.apirest.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Aluno findById(long id);

}
