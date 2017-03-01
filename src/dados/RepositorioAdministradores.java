package dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import negocio.beans.Administrador;

public class RepositorioAdministradores  implements InterfaceCRUD<Administrador,String>{
	private ArrayList<Administrador> administradores;

	public RepositorioAdministradores() 
	{
		this.administradores = new ArrayList<Administrador>();
		if(new File("administradores.dat").canRead() == true)
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
		if(new File("administradores.dat").canRead() == true)
		{
			
			try 
			{
				inc = new FileInputStream("administradores.dat");
				 ois = new ObjectInputStream(inc);
				
				ArrayList <Administrador> administradores = (ArrayList <Administrador>) ois.readObject();
				for(int i = 0; i< administradores.size(); i++)
				{
					this.administradores.add(administradores.get(i));
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
			FOS = new FileOutputStream("administradores.dat");
			OUS  = new ObjectOutputStream(FOS);
			
			OUS.writeObject(administradores);
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
	private int procurarIndice(Administrador administrador)
	{
		int indice = -1;

		for (int i = 0; i < this.administradores.size(); i++) 
		{
			if (this.administradores.get(i).equals(administrador)) 
			{
				indice = i;
			}
		}
		return indice;
	}
	
	public Administrador existe(String cpf)
	{
		Administrador administrador = null;
		for(int i = 0; i< administradores.size();i++)
		{
			if(administradores.get(i).getCpf().equals(cpf))
			{
				administrador = administradores.get(i);
			}
		}
		return administrador;
	}
	@Override
	public void cadastrar(Administrador administrador)
	{
		
          this.administradores.add(administrador);
          this.salvarArquivo();
        
	}
	@Override
	public void remover(Administrador administrador)
	{
		
		  this.administradores.remove(administrador);
		  this.salvarArquivo();
		
	}
	@Override
	public void atualizar(Administrador administrador)  
	{
           int indice = this.procurarIndice(administrador);
           
             this.administradores.set(indice, administrador);
             this.salvarArquivo();
          
     }
	@Override
	public Administrador existe(Administrador administrador)
	{
		Administrador resultado = null;
		for (int i = 0; i < this.administradores.size(); i++) 
		{
			if (this.administradores.get(i).equals(administrador)) 
			{
				return resultado;
				
			}
		}
		return null;
	}
	
	@Override
	public ArrayList<Administrador> listar()
	{
		
		return this.administradores;	
		
	}
	@Override
	public boolean existeCodigo(String cpf)
	{
		boolean resultado = false;
		for (int i = 0; i < this.administradores.size(); i++) 
		{
			if (this.administradores.get(i).getCpf().equals(cpf)) 
			{
				return resultado;
			}
		}
		return false;
	}

}
