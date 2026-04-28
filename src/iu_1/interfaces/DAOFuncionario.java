package iu_1.interfaces;

import iu_1.clases.Funcionario;
import java.util.List;


public interface DAOFuncionario {
    
    public void registrar (Funcionario funcionario) throws Exception;
    
    public void modificar (Funcionario funcionario) throws Exception;
    
    public void eliminar (Funcionario funcionario) throws Exception;
    
    public List<Funcionario> listar() throws Exception;
}
