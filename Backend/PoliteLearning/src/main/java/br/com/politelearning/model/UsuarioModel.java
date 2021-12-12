package br.com.politelearning.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_usuario")
public class UsuarioModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotBlank(message = "O campo não deve conter valor nulo ou espaço vazio ")
	@Size(min = 3, max = 50, message = "É necessário colocar o nome min 3 e max 50")
	private String nome;

	@NotBlank(message = "O campo não deve conter valor nulo ou espaço vazio ")
	@Email // Verifica se o campo possui as características de um endereço de e-mail.
	@Size(min = 3, max = 50, message = "É necessário colocar um email no min 3 e max 50")
	private String email;

	@NotBlank(message = "O campo não deve conter valor nulo ou espaço vazio ")
	@Size(min = 6, max = 8, message = "É necessario colocar uma senha no min 6 e max 8 ")
	private String senha;

	@JsonIgnoreProperties("usuario")
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private List<PostagemModel> postagem;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public List<PostagemModel> getPostagem() {
		return postagem;
	}

	public void setPostagem(List<PostagemModel> postagem) {
		this.postagem = postagem;
	}

}