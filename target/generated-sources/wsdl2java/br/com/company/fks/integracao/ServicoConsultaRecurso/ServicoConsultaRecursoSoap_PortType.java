/**
 * ServicoConsultaRecursoSoap_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.company.fks.integracao.ServicoConsultaRecurso;

public interface ServicoConsultaRecursoSoap_PortType extends java.rmi.Remote {
    public ResponseObterRecurso obterRecursos(RequestObterRecurso objRequestObterRecurso) throws java.rmi.RemoteException;
    public ResponseObterRecursoAnexo obterAnexosRecurso(java.lang.String usuario, java.lang.String senha, java.lang.String protocolo, int instancia, int origemTerceiraInstancia) throws java.rmi.RemoteException;
}
