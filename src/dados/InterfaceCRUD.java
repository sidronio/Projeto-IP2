package dados;

import java.util.ArrayList;

public interface InterfaceCRUD<T,K> {
	
	public void cadastrar(T objeto);
	public void remover(T objeto);
	public void atualizar(T objeto);
	public ArrayList<T> listar() ;
	public T existe(T objeto);
	public boolean existeCodigo(K chave);
	
	
}
