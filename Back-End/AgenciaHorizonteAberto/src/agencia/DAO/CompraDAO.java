package agencia.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import agencia.Compra;
import agencia.Conexao;
import agencia.Pacotes;
import agencia.Usuarios;

public class CompraDAO extends Compra {

	public CompraDAO() {
		super();
		
	}

	public CompraDAO(Usuarios usuarios, Pacotes pacotes, int idCompra) {
		super(usuarios, pacotes, idCompra);
		
	}

	public static void create (Compra compra) {		

		String sql = "INSERT INTO Compra (idUsuario, idPacote) VALUES (?, ?)";     
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			
			conn = Conexao.createConnectionToMysql();
			pstm = conn.prepareStatement(sql);		
			
			pstm.setInt(1, compra.getUsuarios().getIdUsuario());
            pstm.setInt(2, compra.getPacotes().getIdPacote());    
            pstm.execute();		
			
			System.out.println("Compra realizada com sucesso!");
			
		} 		catch (Exception e) {
			e.printStackTrace();			
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn!= null) {
					conn.close();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}
	
	public static void remove (int id) {

		String sql = "DELETE FROM compra WHERE idCompra = ?";	
		Connection conn = null;		
		PreparedStatement pstm = null;

			try {
				conn = Conexao.createConnectionToMysql();
				pstm = conn.prepareStatement(sql);		
				pstm.setInt(1, id);		
				pstm.execute();				

				System.out.println("Compra deletada com sucesso!");
				
			} catch (Exception e) {
				e.printStackTrace();

			}finally {
				try {
					if (pstm != null) {
						pstm.close();
					}
					if (conn != null) {
						conn.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}	
	
	public static List<Compra> getAllCompras() {
        List<Compra> compras = new ArrayList<>();

        try {
                       // Consulta SQL para obter as informações de compra com detalhes de usuário e pacote
            String sql = "SELECT Compra.idCompra, Usuarios.nome AS nomeUsuario, Pacotes.destino AS destinoPacote " +
                         "FROM Compra " +
                         "JOIN Usuarios ON Compra.idUsuario = Usuarios.idUsuario " +
                         "JOIN Pacotes ON Compra.idPacote = Pacotes.idPacote";

            Connection conn = null;
    		PreparedStatement pstm = null;
    		ResultSet rset = null; 

            // Processar os resultados
            while (rset.next()) {
                int idCompra = rset.getInt("idCompra");
                String nomeUsuario = rset.getString("nomeUsuario");
                String destinoPacote = rset.getString("destinoPacote");

                Compra compra = new Compra();
                compras.add(compra);
            }

            // Fechar os recursos
            rset.close();
            pstm.close();
            pstm.close();
        } catch (Exception e) {
			e.printStackTrace();
		}

        return compras;
    }
	
	
}