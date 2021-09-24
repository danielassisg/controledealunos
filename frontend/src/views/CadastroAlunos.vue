<template>
  <div id="cadastroalunos">

    <nav class="navbar navbar-light bg-light">
      <button style="margin-left:1%" @click="home()" class="btn btn-secondary">Voltar</button>
      <span style="margin-right:45%" class="navbar-brand mb-0 h1">Controle de Alunos</span>
    </nav>

    <div class="container">

      <form @submit.prevent="salvar()" enctype="multipart/form-data">

        <div class="mb-3">
          <label class="form-label">Nome</label>
          <input type="text" class="form-control" placeholder="Nome" v-model="aluno.nome">
        </div>
        <div class="mb-3">
          <label class="form-label">Endereço</label>
          <input type="text" class="form-control" placeholder="Endereço" v-model="aluno.endereco">
        </div>
        <div class="mb-3">
          <label class="form-label">Foto</label> 
          <br>
          <input @change="imagemSelecionada" type="file" class="form-control" enctype="multipart/form-data" placeholder="Foto" style="display:none" ref="fotoInput" accept="" v-on:change="aluno.foto">
          <a @click="$refs.fotoInput.click()" class="btn btn-secondary">Escolher arquivo</a>
          <a @click="uploadImagem" class="btn btn-secondary" style="margin-left:5px;">Enviar</a>
        </div>
        <button type="submit" class="btn btn-primary">Salvar</button>

      </form>

      <table class="table">

        <thead class="thead-dark">

          <tr>
            <th scope="col">NOME</th>
            <th scope="col">ENDEREÇO</th>
            <th scope="col">FOTO</th>
            <th scope="col">EDITAR</th>
            <th scope="col">EXCLUIR</th>
          </tr>

        </thead>

        <tbody>

          <tr v-for="aluno of alunos" :key="aluno.id">

            <td>{{aluno.nome}}</td>
            <td>{{aluno.endereco}}</td>
            <td>{{aluno.foto}}</td>
            <td><i @click="editar(aluno)" class="bi bi-pencil-fill"></i></td>
            <td><i @click="excluir(aluno)" class="bi bi-trash-fill"></i></td>

          </tr>

        </tbody>
      
      </table>

    </div>

  </div>
</template>

<script>

import Aluno from '../services/alunos'

export default {
  data(){
    return{
      alunos:[],
      aluno:{
        id: '',
        nome: '',
        endereco: '',
        foto: null
      },
      arquivoSelecionado:null
    }
  },

  mounted(){
    this.listar()
    this.$ForceUpdate ();
  },

  methods:{
    salvar(){
      if(!this.aluno.id){
          if(this.aluno.nome!=null && this.aluno.endereco!=null){
              Aluno.salvar(this.aluno).then(response => {
              this.aluno = {}
              this.response = response;
              alert('Salvo com sucesso!')
              this.listar()
              })
          }else{
            alert('Campos nome e endereço são obrigatórios')
          }
      }else{
        Aluno.salvar(this.aluno).then(response => {
          this.aluno = {}
          this.response = response;
          alert('Atualizado com sucesso!')
          this.listar()
        })
      }
      
    },

    listar(){
      Aluno.listar().then(response => {
        this.aluno = {}
        this.alunos = response.data;
      })
    },

    editar(aluno){
      this.aluno = aluno
    },

    excluir(aluno){
      if(confirm('Deseja excluir esse aluno do sistema?')){
        Aluno.deletar(aluno).then(response =>{
          this.listar()
          this.response = response;
        })
      }
    },
    imagemSelecionada(event){
        this.arquivoSelecionado = event.target.files[0]
        alert('Aquivo '+ this.arquivoSelecionado.name + ' foi selecionado!')
    },
    uploadImagem(){
        if(this.arquivoSelecionado.type == "image/jpeg"){
          this.aluno.foto = this.arquivoSelecionado;
          console.log(this.aluno.foto)
        }else{
          alert('Apenas imagens no formato jpg são aceitas!')
        }
    },
    home(){
      this.$router.push('/')
    }
  }
}
</script>
<style>
</style>
