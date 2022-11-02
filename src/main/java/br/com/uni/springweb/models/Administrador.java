package br.com.uni.springweb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.Type;
 

 

@Entity // anotação para informar que a classe é responsavel por criar e manipular a
        // tabela no banco de dados
@Table(name = "administradores")
public class Administrador {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id") // as anotações para o nome da coluna são opçionais
private int id;
@Column(name = "nome",length = 100,nullable = false)
private String nome;
@ Column(name = "email",length = 180,nullable = false)
private String email;
@ Column(name = "senha",length = 100,nullable = false)
private String senha;
@ Column(name = "observacao" )
@Type(type = "text")
private String observacao;


public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
public String getEmail() {
    return email;
}
public void setEmail(String email) {
    this.email = email;
}
public String getSenha() {
    return senha;
}
public void setSenha(String senha) {
    this.senha = senha;
}
public String getObservacao() {
    return observacao;
}
public void setObservacao(String observacao) {
    this.observacao = observacao;
}

}
