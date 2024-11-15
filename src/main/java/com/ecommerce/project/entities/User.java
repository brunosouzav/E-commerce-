package com.ecommerce.project.entities;

import java.util.List;

import com.ecommerce.project.enus.UserRole;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of= "id")
public class User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Nome não pode ser vazio")
    private String name;

    @Email(message = "Email inválido")
    @NotEmpty(message = "Email não pode ser vazio")
    private String email;

    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    private String password;
    
    @OneToMany(mappedBy = "user")
    private List<Address> addresses;; 

    @Enumerated(EnumType.STRING) 
    private UserRole role; 
}
