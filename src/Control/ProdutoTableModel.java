/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Produto;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author wellington.rigoni
 */
public class ProdutoTableModel extends AbstractTableModel{
    //Lista de Sócios a serem exibidos na tabela
    private List<Produto> linhas;
    private static final int CODPROD =0;
    private static final int DESCRICAO = 1;
    private static final int OBS = 2;
    private static final int ESTOQUE = 3;
     
    //Array com os nomes das colunas.
    private String[] colunas = new String[] {"Codprod", "Descricao","Obs","Estoque"};
            
    //Cria um SocioTableModel sem nenhuma linha
    public ProdutoTableModel(){
        linhas = new ArrayList<Produto>();
    }
    
    //Cria um SocioTableModel contendo a lista recebida por parametro
    public ProdutoTableModel(List<Produto> listaDeProdutos){
        linhas = new ArrayList<Produto>(listaDeProdutos);
    }
    
    @Override
    public int getRowCount(){
        return linhas.size();
    }
    
    @Override
    public int getColumnCount(){
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return colunas[columnIndex];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case CODPROD:
                return int.class;
            case DESCRICAO:
                return String.class;
            case OBS:
                return String.class;
            case ESTOQUE:
                return int.class;
            default:
                //Não deve ocorrer, pois só existem 2 colunas
                throw new IndexOutOfBoundsException("columnIndex out of bounds");
    }
    }
    
   /* @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return columnIndex == ATIVO;
    }*/
    
    @Override
    public Object getValueAt(int rowIndex,int columnIndex){
         //Pega o sócio referente a linha especificada
        Produto produto = linhas.get(rowIndex);
       
        switch (columnIndex){
            case CODPROD:
                return produto.getCodProd();
            case DESCRICAO:
                return produto.getDescricao();
            case OBS:
                return produto.getObs();
            case ESTOQUE:
                return produto.getEstoque();
            default:
                throw new IndexOutOfBoundsException("column index out of bounds");
                
                            
        }
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex){
         //Pega o sócio referente a linha especificada
        Produto produto = linhas.get(rowIndex);
       
        switch (columnIndex){
            case CODPROD:
                produto.setCodProd((int) aValue);
                break;
            case DESCRICAO:
                produto.setDescricao((String) aValue);
                break;
            case OBS:
                produto.setObs((String) aValue);
                break;
            default:
                throw new IndexOutOfBoundsException("column index out of bounds");
        }
        fireTableCellUpdated(rowIndex,columnIndex);// Notifica a atualização da célula
    }
    
    //Retorna o sócio referente a linha especificada 
    public Produto getProduto(int indiceLinha) {
        return linhas.get(indiceLinha);
    }
    
    //Adiciona o sócio especificado ao modelo
    public void addProduto(Produto produto){
        //Adiciona o registro
        linhas.add(produto);
        
        //Pega a quantidade de registros e subtrai 1 para 
        //achar o ultimo indice. Asubtração é necessária
        //pois os indices comecam em 0
        int ultimoIndice = getRowCount() -1;
        //Notifica mudança 
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    //Remove o sócio da linha especificada.
    public void removeProduto(int indiceLinha){
        //Remove o registro
        linhas.remove(indiceLinha);
        //notifica mudancas
        fireTableRowsDeleted(indiceLinha, indiceLinha);
    }
    
    //Adciona uma lista de socios no final da lista
    public void addListaDeProdutos(List<Produto> produtos){
        //Pega o tamanho antigo da tabela, que servira como 
        //indice para o primeiro dos novos registros
        int indice = getRowCount();
        
        //Adciona os registros
        linhas.addAll(produtos);
        
        //Notifica a mudança
        fireTableRowsInserted(indice, indice + produtos.size());
    }
    
    //Remove todos os registros 
    public void limpar(){
        //Remove todos os elementos da lista
        linhas.clear();
        
        //Notifica a mudança
        fireTableDataChanged();
    }
    
    
    
}
