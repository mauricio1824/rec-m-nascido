/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.RecemNascido;

public class DaoRecemNascido {

    public static boolean inserir(RecemNascido objeto) {
        String sql = "INSERT INTO recemnascido (nome_mae, peso, n_quarto, sexo ) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome_mae());
            ps.setDouble(2, objeto.getPeso());
            ps.setInt(3, objeto.getN_quarto());
            ps.setString(4, objeto.getSexo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        RecemNascido objeto = new RecemNascido();
        objeto.setNome_mae("Carla");
        objeto.setPeso(5.0);
        objeto.setN_quarto(15);
        objeto.setSexo("M");
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
}
