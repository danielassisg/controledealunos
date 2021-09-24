<template>
    <div class="home">
        <nav class="navbar navbar-light bg-light">
            <span style="margin-left:42%" class="navbar-brand mb-0 h1">Controle de Alunos</span>
        </nav>
            <div class="mb-3" style="margin-left: 35%; margin-top:10%">
                <img alt="logo delta" src="../assets/logo.png" />
                <br>
                <button  @click="entrar()" class="btn btn-primary" style="margin-left:10%; margin-top:10%">Entrar no sistema</button>
            </div>
    </div>
    
</template>
<script>
    export default {
        data(){

        },
        methods:{
            entrar(){
                this.$router.push('/cadastroalunos')
            }
        }  
    }
</script>
<style>

</style>