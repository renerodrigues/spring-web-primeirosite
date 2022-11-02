package br.com.uni.springweb.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.uni.springweb.models.Administrador;

public interface AdministradoresRepo extends CrudRepository<Administrador, Integer> {
    
    @Query(value = "select * from administradores where email = :email and senha = :senha", nativeQuery = true)
    public Administrador Login(@Param("email") String email, @Param("senha") String senha);

}
