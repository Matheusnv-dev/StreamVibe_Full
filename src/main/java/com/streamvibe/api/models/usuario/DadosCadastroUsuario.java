package com.streamvibe.api.models.usuario;

import com.streamvibe.api.models.endereco.DadosCadastroEndereco;

public record DadosCadastroUsuario(
                String nome,
                String dataDeNascimento,
                String email,
                String senha,
                String cpf,
                DadosCadastroEndereco endereco

) {

}
