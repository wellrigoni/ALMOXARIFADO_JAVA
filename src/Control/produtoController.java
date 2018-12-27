/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Funcionario;
import Model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author wellington.rigoni
 */
public class produtoController {
    connectionBD connection; 
    
    
    public List<Produto> consultaProdAlmox(int codprod, String descricao){
        Produto prod;
        connection = new connectionBD();
        List<Produto> produtos = new ArrayList<>();
        try {
            Connection con = connection.conectaBD();                        
            String sql = "select codprod, descricao,obs, ESTOQUE from wc_almox"; 
            if (codprod != 0){
                sql += " where codprod =" +codprod;
            }
            if (descricao.length() > 1){
                sql += " where descricao like '%" +descricao+"%'";
            }
            System.out.println(sql.toUpperCase());
            
            PreparedStatement stmt = con.prepareStatement(sql.toUpperCase());
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                 prod = new Produto();
                    prod.setCodProd(rs.getInt(1));
                    prod.setDescricao(rs.getString(2));
                    prod.setObs(rs.getString(3)); 
                    prod.setEstoque(rs.getInt(4));
                    
                    produtos.add(prod);
                    }
            
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("error" + e);
        }        
        return produtos;
    } 
    
    public void salvaSolicitacao(Funcionario solicitante, Funcionario solicitado,Produto produto, int qtd ){
        Produto prod = new Produto();
        connection = new connectionBD();
        List<Produto> produtos = new ArrayList<>();
        try {
            Connection con = connection.conectaBD();
                        
            String sql = "INSERT into wc_almox_mov (codprod, qtdmov, funcsolic, funcautoriza, dtmov) \n" +
"values\n" +
"("+produto.getCodProd()+","+qtd+","+solicitante.getCodfunc()+","+solicitado.getCodfunc()+",SYSDATE)";
            
            PreparedStatement stmt = con.prepareStatement(sql.toUpperCase());
            
            ResultSet rs = stmt.executeQuery();
                                  
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("error" + e);
        }
       
    } 
    
public void preencheSolicitacao(int qtd){// testando metodo salvaSolicitacao
        
    Funcionario solicitante = new Funcionario(59,"Magna");
    Funcionario solicitado = new Funcionario(118,"Wellington");
    
    Produto prod = new Produto();
    prod.setCodProd(22);
    
    
    
    this.salvaSolicitacao(solicitante, solicitado, prod, 2);
   
    
    
    
    
    /*Funcionario prod = new Funcionario();
        connection = new connectionBD();
        
        try {
            Connection con = connection.conectaBD();
                        
            String sql = "select codprod, descricao,obs, ESTOQUE from wc_almox where codprod =" +codprod;
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                    prod.setCodProd(rs.getInt(1));
                    prod.setDescricao(rs.getString(2));
                    prod.setObs(rs.getString(3)); 
                    prod.setEstoque(rs.getInt(4));
                    
                    produtos.add(prod);
            }
            
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("error" + e);
        }
        return produtos;*/
    }    

public List<Funcionario> consultaFuncionarios(){
    Funcionario func;
        connection = new connectionBD();
        List<Funcionario> funcionarios = new ArrayList<>();
        try {
            Connection con = connection.conectaBD();                        
            String sql = "select matricula, nome from pcempr"; 
            
            System.out.println(sql.toUpperCase());
            
            PreparedStatement stmt = con.prepareStatement(sql.toUpperCase());
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                 func = new Funcionario(0, sql);
                    func.setCodfunc(rs.getInt(1));
                    func.setNome(rs.getString(2));
                   
                    
                    funcionarios.add(func);
                    }
            
            stmt.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("error" + e);
        }        
    
    return null;
}
        
}


