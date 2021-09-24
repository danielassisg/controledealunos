package com.alunos.apirest.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.alunos.apirest.models.Aluno;
import com.alunos.apirest.repository.AlunoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@Api(value="API REST alunos")
@CrossOrigin(origins = "*")
public class AlunoController extends Aluno {

    @Autowired
    AlunoRepository alunoRepository;

    @GetMapping("/alunos")
    @ApiOperation(value="Retorna uma lista de alunos")
    public List<Aluno> listaAlunos(){
        return alunoRepository.findAll();
    }

    @GetMapping("/alunos/{id}")
    @ApiOperation(value="Retorna um aluno único")
    public Optional<Aluno> listaAlunoUnico(@PathVariable(value="id") long id){
        return Optional.ofNullable(alunoRepository.findById(id));
    }

    @PostMapping("/aluno")
    @ApiOperation(value="Salva um aluno")
    public Aluno salvaAluno(@RequestBody Aluno aluno){
        return alunoRepository.save(aluno);
    }
    @DeleteMapping("/aluno")
    @ApiOperation(value="Deleta um aluno")
    public void deletaAluno(@RequestBody Aluno aluno){
        alunoRepository.delete(aluno);
    }

    @PutMapping("/")
    @ApiOperation(value="Atualiza um aluno")
    public Aluno atualizaAluno(@RequestBody Aluno aluno){
        return alunoRepository.save(aluno);
    }

}
