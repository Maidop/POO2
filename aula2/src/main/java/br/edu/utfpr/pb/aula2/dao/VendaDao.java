/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.pb.aula2.dao;

import br.edu.utfpr.pb.aula2.model.Venda;

/**
 *
 * @author Maikon
 */
public class VendaDao extends GenericDao<Venda, Long>{

    public VendaDao() {
        super(Venda.class);
    }
    
}
