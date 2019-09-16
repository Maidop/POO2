/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.pb.aula2.dao;

import br.edu.utfpr.pb.aula2.model.VendaProduto;

/**
 *
 * @author Maikon
 */
public class VendaProdutoDao extends GenericDao<VendaProduto, Long>{

    public VendaProdutoDao() {
        super(VendaProduto.class);
    }
    
}
