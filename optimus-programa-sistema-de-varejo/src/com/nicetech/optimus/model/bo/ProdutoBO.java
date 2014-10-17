package com.nicetech.optimus.model.bo;

import com.nicetech.optimus.model.dao.DaoProduto;
import com.nicetech.optimus.model.vo.ModelProduto;
import static com.nicetech.optimus.utils.ValidaForm.isValid;
import java.util.List;

public class ProdutoBO {

    public static List<ModelProduto> getProdutos() {
        return DaoProduto.getProdutos();
    }
    
    private final DaoProduto dao;

    public ProdutoBO() {
        this.dao = new DaoProduto();
    }
    
    public boolean cadastrar(String text, String text0, String text1, String text2, String text3, String text4, String text5, String text6, String text7) {
       
        ModelProduto prod = new ModelProduto();  
        prod.setNome(text);
        prod.setMarca(text7);
        prod.setModelo(text);
        prod.setTipo(text);
        prod.setCor(text);
        prod.setDescricao(text7);
        prod.setPreco(1.1);
        prod.setGarantia(text7);
        prod.setDesconto(1);
 
        
        if (isValid(prod)) {
            DaoProduto.getProdutos().add(prod);
            this.dao.createXml(DaoProduto.getProdutos());
            return true;
        }
        return false;
    }

    public List<?> searchRecord(String idFornecedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<?> searchRecordFiltro(String Output, String idFornecedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<?> searchRecord(String Output, String idFornecedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
