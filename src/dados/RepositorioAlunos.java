package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import negocio.beans.Aluno;

public class RepositorioAlunos implements InterfaceCRUD<Aluno,String>{
	private ArrayList<Aluno> alunos;

	public RepositorioAlunos() 
	{
		this.alunos = new ArrayList<Aluno>();
		if(new File("alunos.dat").canRead() == true)
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
		if(new File("alunos.dat").canRead() == true)
		{
			
			try 
			{
				inc = new FileInputStream("alunos.dat");
				 ois = new ObjectInputStream(inc);
				
				ArrayList <Aluno> livros = (ArrayList <Aluno>) ois.readObject();
				for(int i = 0; i< livros.size(); i++)
				{
					this.alunos.add(livros.get(i));
				}
				
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
			FOS = new FileOutputStream("alunos.dat");
			OUS  = new ObjectOutputStream(FOS);
			
			OUS.writeObject(alunos);
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
	private int procurarIndice(Aluno aluno)
	{
		int indice = -1;

		for (int i = 0; i < this.alunos.size(); i++) 
		{
			if (this.alunos.get(i).equals(aluno)) 
			{
				indice = i;
			}
		}
		return indice;
	}
	public Aluno existe(String cpf)
	{
		Aluno aluno = null;
		for(int i = 0; i< alunos.size();i++)
		{
			if(alunos.get(i).getCpf().equals(cpf))
			{
				aluno = alunos.get(i);
			}
		}
		return aluno;
	}
	@Override
	public void cadastrar(Aluno aluno) 
	{
        	this.alunos.add(aluno);
        	this.salvarArquivo();
	}
	@Override
	public void remover(Aluno aluno)
	{
		
		  this.alunos.remove(aluno);
		  this.salvarArquivo();
		
	}
	@Override
	public void atualizar(Aluno aluno)  
	{
           int indice = this.procurarIndice(aluno);
           this.alunos.set(indice, aluno);
           this.salvarArquivo();
     }
	@Override
	public Aluno existe(Aluno aluno)
	{
		Aluno resultado = null;
		for (int i = 0; i < this.alunos.size(); i++) 
		{
			if (this.alunos.get(i).equals(aluno)) 
			{
				return resultado;
				
			}
		}
		return null;
	}
	
	@Override
	public ArrayList<Aluno> listar()
	{
		
			return this.alunos;
	}
	@Override
	public boolean existeCodigo(String cpf)
	{
		boolean resultado = false;
		for (int i = 0; i < this.alunos.size(); i++) 
		{
			if (this.alunos.get(i).getCpf().equals(cpf)) 
			{
				return resultado;
				
			}
		}
		return false;
	}
}
