import { http } from './config'

export default {

    listar:() => {
        return http.get('alunos')
    },

    salvar:(aluno) => {
        return http.post('aluno', aluno)
    },

    atualizar:(aluno) => {
        return http.put("aluno/"+ aluno.id , aluno)
    },

    deletar:(aluno) =>{
        return http.delete('aluno', {data: aluno})
    }
    
}