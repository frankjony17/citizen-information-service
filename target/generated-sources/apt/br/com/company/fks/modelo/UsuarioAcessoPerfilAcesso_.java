package br.com.company.fks.modelo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UsuarioAcessoPerfilAcesso.class)
public abstract class UsuarioAcessoPerfilAcesso_ {

	public static volatile SingularAttribute<UsuarioAcessoPerfilAcesso, Boolean> isAtivo;
	public static volatile SingularAttribute<UsuarioAcessoPerfilAcesso, PerfilAcessos> perfilAcessos;
	public static volatile SingularAttribute<UsuarioAcessoPerfilAcesso, UsuarioAcessos> usuarioAcessos;
	public static volatile SingularAttribute<UsuarioAcessoPerfilAcesso, Long> id;
	public static volatile SingularAttribute<UsuarioAcessoPerfilAcesso, String> papel;

}

