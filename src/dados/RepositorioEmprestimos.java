package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import negocio.beans.Emprestimo;

public class RepositorioEmprestimos implements InterfaceCRUD<Emprestimo,Integer>{
	private ArrayList<Emprestimo> emprestimos;

	public RepositorioEmprestimos() 
	{
		this.emprestimos = new ArrayList<Emprestimo>();
		if(new File("emprestimos.dat").canRead() == true)
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
		if(new File("emprestimos.dat").canRead() == true)
		{
			
			try 
			{
				inc = new FileInputStream("emprestimos.dat");
				 ois = new ObjectInputStream(inc);
				
				ArrayList <Emprestimo> emprestimos = (ArrayList <Emprestimo>) ois.readObject();
				for(int i = 0; i< emprestimos.size(); i++)
				{
					this.emprestimos.add(emprestimos.get(i));
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
			FOS = new FileOutputStream("emprestimos.dat");
			OUS  = new ObjectOutputStream(FOS);
			
			OUS.writeObject(emprestimos);
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
	private int procurarIndice(Emprestimo emprestimo)
	{
		int indice = -1;

		for (int i = 0; i < this.emprestimos.size(); i++) 
		{
			if (this.emprestimos.get(i).equals(emprestimos)) 
			{
				indice = i;
			}
		}
		return indice;
	}
	public Emprestimo existe(int codigo)
	{
		Emprestimo emprestimo = null;
		for(int i = 0; i< emprestimos.size();i++)
		{
			if(emprestimos.get(i).getCodigo() == codigo)
			{
				emprestimo = emprestimos.get(i);
			}
		}
		return emprestimo;
	}
	@Override
	public void cadastrar(Emprestimo emprestimo)
	{
		
          this.emprestimos.add(emprestimo);
          this.salvarArquivo();
       
	}
	@Override
	public void remover(Emprestimo emprestimo)
	{
		
		  this.emprestimos.remove(emprestimo);
		  this.salvarArquivo();
		
	}
	@Override
	public void atualizar(Emprestimo emprestimo)  
	{
           int indice = this.procurarIndice(emprestimo);
           this.emprestimos.set(indice, emprestimo);
           this.salvarArquivo();
           
     }
	@Override
	public Emprestimo existe(Emprestimo emprestimo)
	{
		Emprestimo resultado = null;
		for (int i = 0; i < this.emprestimos.size(); i++) 
		{
			if (this.emprestimos.get(i).equals(emprestimo)) 
			{
				return resultado;
				
			}
		}
		return null;
	}
	
	@Override
	public ArrayList<Emprestimo> listar()
	{
			return this.emprestimos;	
		
	}
	@Override
	public boolean existeCodigo(Integer codigo)
	{
		boolean resultado = false;
		for (int i = 0; i < this.emprestimos.size(); i++) 
		{
			if (this.emprestimos.get(i).getCodigo() == codigo) 
			{
				return resultado;
				
			}
		}
		return false;
	}
}
