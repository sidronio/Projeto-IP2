package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import negocio.beans.Livro;

public class RepositorioLivros implements InterfaceCRUD<Livro,Integer>{
	
	private ArrayList<Livro> livros;

	public RepositorioLivros() 
	{
		this.livros = new ArrayList<Livro>();
		if(new File("livros.dat").canRead() == true)
		{
			this.lerArquivo();
		}
		else
		{
			this.salvarArquivo();
		}
	}
	private void lerArquivo() 
	{
		FileInputStream inc = null;
		ObjectInputStream ois = null;
		if(new File("livros.dat").canRead() == true)
		{
			
			try 
			{
				inc = new FileInputStream("livros.dat");
				 ois = new ObjectInputStream(inc);
				
				ArrayList <Livro> livros = (ArrayList <Livro>) ois.readObject();
				for(int i = 0; i< livros.size(); i++)
				{
					this.livros.add(livros.get(i));
				}
				System.out.println("Livros Carregados");
			} 
			catch (IOException | ClassNotFoundException e) 
			{
				
			} 
			finally{
				try {
					inc.close();
					ois.close();
				} catch (IOException e) {
				}
				
			}
	     }
     }
	private void salvarArquivo() 
	{
		FileOutputStream FOS = null;
		ObjectOutputStream OUS = null;
		try
		{
			FOS = new FileOutputStream("livros.dat");
			OUS  = new ObjectOutputStream(FOS);
			
			OUS.writeObject(livros);
			OUS.close();
		}
		catch(IOException e)
		{
			
		}
		finally{
			try {
				FOS.close();
				OUS.close();
			} catch (IOException e) {
				
			}
			
		}
	}
	private int procurarIndice(Livro livro)
	{
		int indice = -1;

		for (int i = 0; i < this.livros.size(); i++) 
		{
			if (this.livros.get(i).equals(livro)) 
			{
				indice = i;
			}
		}
		return indice;
	}
	public Livro existe(int codigo)
	{
		Livro livro = null;
		for(int i = 0; i< livros.size();i++)
		{
			if(livros.get(i).getIsbn() == codigo)
			{
				livro = livros.get(i);
			}
		}
		return livro;
	}
	@Override
	public void cadastrar(Livro livro) 
	{
          this.livros.add(livro);
          this.salvarArquivo();
        
	}
	@Override
	public void remover(Livro livro) 
	{
		
		  this.livros.remove(livro);
		  this.salvarArquivo();
		
	}
	@Override
	public void atualizar(Livro livro)  
	{
           int indice = this.procurarIndice(livro);
          
           this.livros.set(indice, livro);
           this.salvarArquivo();
          
     }
	@Override
	public Livro existe(Livro livro)
	{
		Livro resultado = null;
		for (int i = 0; i < this.livros.size(); i++) 
		{
			if (this.livros.get(i).equals(livro)) 
			{
				return resultado;
				
			}
		}
		return null;
	}
	
	@Override
	public ArrayList<Livro> listar()
	{
			return this.livros;	
		
	}
	@Override
	public boolean existeCodigo(Integer chave){
		
		
		for (int i = 0; i < this.livros.size(); i++) 
		{
			if (this.livros.get(i).getIsbn() == chave) 
			{
				return true;
				
			}
		}
		return false;
	}
	
}
