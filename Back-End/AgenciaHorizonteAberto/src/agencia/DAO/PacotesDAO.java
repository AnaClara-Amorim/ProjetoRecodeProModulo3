package agencia.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import agencia.Conexao;
import agencia.Pacotes;

public class PacotesDAO extends Pacotes {

	public PacotesDAO(int idPacote, String destino, double preco, String promocao) {
		super(idPacote, destino, preco, promocao);
		// TODO Auto-generated constructor stub
	}
	
	public static void create (Pacotes pacote) {
		String sql = "INSERT INTO pacotes (destino, preco, promocao) "+" VALUES (?,?,?)";
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = Conexao.createConnectionToMysql();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, pacote.getDestino());
			pstm.setDouble(2, pacote.getPreco());
			pstm.setString(3, pacote.getPromocao());
			
			pstm.execute();			
			
			System.out.println("Criado com sucesso!");
			
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
	
	public static void remove(int idPacote) {

		String sql = "DELETE FROM pacotes WHERE idPacote = ?";	
		Connection conn = null;		
		PreparedStatement pstm = null;

			try {
				conn = Conexao.createConnectionToMysql();
				pstm = conn.prepareStatement(sql);		
				pstm.setInt(1, idPacote);		
				pstm.execute();				

				System.out.println("Pacote deletado com sucesso!");
				
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
	
	public static void update (Pacotes pacote) {
		String sql = "UPDATE pacotes SET destino = ?, preco = ?, promocao = ? WHERE idPacote = ? ";
		Connection conn = null;

		PreparedStatement pstm = null;

			try {
				conn = Conexao.createConnectionToMysql();
				pstm = conn.prepareStatement(sql);
				

				pstm.setString(1, pacote.getDestino());
				pstm.setDouble(2, pacote.getPreco());	
				pstm.setString(3, pacote.getPromocao());
				pstm.setInt(4, pacote.getIdPacote());		
				pstm.execute();

				System.out.println("Atualizado com sucesso!");				

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
	
	public static List<Pacotes> getUsers(){		

		String sql = "SELECT * FROM pacotes";		

		List<Pacotes> pacotes = new ArrayList<Pacotes>();		

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null; 

			try {
				conn = Conexao.createConnectionToMysql();
				pstm = conn.prepareStatement(sql);
				rset = pstm.executeQuery();				

				while (rset.next()) {
					Pacotes pacote = new Pacotes();			
					pacote.setIdPacote(rset.getInt("idPacote"));
					pacote.setDestino(rset.getString("destino"));
					pacote.setPreco(rset.getDouble("preco"));
					pacote.setPromocao(rset.getString("promocao"));	
					pacotes.add(pacote);				
				}					

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
					if(rset != null) {
						rset.close();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			return pacotes;
	}
	

}
