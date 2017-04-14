package edu.ncsu.monopoly.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import edu.ncsu.monopoly.GameBoard;
import edu.ncsu.monopoly.GameMaster;
import edu.ncsu.monopoly.ManejadorComienzoPartida;
import edu.ncsu.monopoly.Perfil;
import edu.ncsu.monopoly.test.boardScenarios.GameBoardFull;

import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import javax.swing.*;
import java.awt.Image;
import java.awt.Font;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
public class SeleccionDePerfil extends JFrame {

	private JPanel contentPane;
	private JTextField tbNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SeleccionDePerfil frame = new SeleccionDePerfil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SeleccionDePerfil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JLabel lblImagenUsuario = new JLabel("Avatar del usuario");
		lblImagenUsuario.setBounds(166, 37, 113, 119);
		contentPane.add(lblImagenUsuario);
		
		final JLabel lblSeleccionDeUsuario = new JLabel();
		lblSeleccionDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeleccionDeUsuario.setText("Seleccion de Usuario");
		lblSeleccionDeUsuario.setBounds(new Rectangle(14, 16, 142, 16));
		contentPane.add(lblSeleccionDeUsuario);
		
		final JList lbUsuariosPartida = new JList();
		lbUsuariosPartida.setBounds(new Rectangle(12, 36, 140, 140));
		lbUsuariosPartida.setBounds(459, 43, 140, 113);
		contentPane.add(lbUsuariosPartida);
		
		final JList lbUsuarios = new JList();
		lbUsuarios.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				try{
				lblImagenUsuario.setIcon(null);	
				Perfil p=(Perfil) lbUsuarios.getSelectedValue();
				if (p.getImagen()!=null)lblImagenUsuario.setIcon(p.getImagen());
				}
				catch(Exception ex){
					lblImagenUsuario.setIcon(null);					
				}
			}
		});
		lbUsuarios.setBounds(new Rectangle(12, 36, 144, 120));
		contentPane.add(lbUsuarios);
		
		final JComboBox cbColor = new JComboBox();
		cbColor.setEditable(true);
		cbColor.setModel(new DefaultComboBoxModel(new String[] {"Rojo", "Verde", "Amarillo", "Azul", "Blanco", "Negro", "Violeta", "Naranja"}));
		cbColor.setBounds(291, 99, 118, 20);
		contentPane.add(cbColor);
		

		final JLabel lblImagen = new JLabel("Seleccione Imagen");
		lblImagen.setBounds(209, 245, 113, 137);
		contentPane.add(lblImagen);
		
		JButton btnAgregarAPartida = new JButton();
		btnAgregarAPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				
				Perfil p =(Perfil) lbUsuarios.getSelectedValue();
				
				
				if(p!=null){
					p.setColorFicha(cbColor.getSelectedItem().toString());
					cbColor.removeItemAt(cbColor.getSelectedIndex());
				
				
				ManejadorComienzoPartida.instance().getListaDePerfilesNoSeleccionados().remove(p);
				ManejadorComienzoPartida.instance().getListaDePerfilesSeleccionados().add(p);
				lbUsuarios.setListData(ManejadorComienzoPartida.instance().getListaDePerfilesNoSeleccionados().toArray());
				lbUsuariosPartida.setListData(ManejadorComienzoPartida.instance().getListaDePerfilesSeleccionados().toArray());
			    }else{
					JOptionPane.showMessageDialog(getParent(), "Seleccione un usuario" );
				}
		}
		});
		btnAgregarAPartida.setText("Agregar a partida -> ");
		btnAgregarAPartida.setBounds(new Rectangle(289, 42, 160, 26));
		contentPane.add(btnAgregarAPartida);
		
		
		
		tbNombre = new JTextField();
		tbNombre.setBounds(new Rectangle(14, 280, 120, 24));
		contentPane.add(tbNombre);
		
		JLabel label_1 = new JLabel();
		label_1.setText("Nombre");
		label_1.setBounds(new Rectangle(14, 264, 78, 16));
		contentPane.add(label_1);
		
		JButton btnSubirFoto = new JButton();
		btnSubirFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser file = new JFileChooser();
		          file.setCurrentDirectory(new File(System.getProperty("user.home")));
		          //filter the files
		          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
		          file.addChoosableFileFilter(filter);
		          int result = file.showSaveDialog(null);
		           //if the user click on save in Jfilechooser
		          if(result == JFileChooser.APPROVE_OPTION){
		              File selectedFile = file.getSelectedFile();
		              String path = selectedFile.getAbsolutePath();
		             lblImagen.setIcon(ResizeImage(path,lblImagen));
		          }
		           //if the user click on save in Jfilechooser


		          else if(result == JFileChooser.CANCEL_OPTION){
		              System.out.println("No File Select");
		          }
		        }
			
		});
		btnSubirFoto.setText("Seleccionar Imagen");
		btnSubirFoto.setBounds(new Rectangle(404, 224, 165, 27));
		btnSubirFoto.setBounds(14, 319, 165, 27);
		contentPane.add(btnSubirFoto);
		
		
		
		JLabel lblColorDeFicha = new JLabel();
		lblColorDeFicha.setText("Color de ficha");
		lblColorDeFicha.setBounds(new Rectangle(404, 11, 78, 16));
		lblColorDeFicha.setBounds(289, 79, 78, 16);
		contentPane.add(lblColorDeFicha);
		
		JButton btnCrearPerfilDe = new JButton();
		btnCrearPerfilDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					
			if (tbNombre.getText().isEmpty()==false){
					String nombre = tbNombre.getText();
					ImageIcon imagen=(ImageIcon) lblImagen.getIcon();
					
					Perfil p=new Perfil();					
					p.setNombreDeUsuario(tbNombre.getText());
					if (imagen!=null)p.setImagen(imagen);
					lblImagen.setIcon(null);
					boolean salida=false;
					if (ManejadorComienzoPartida.instance().getListaDePerfilesNoSeleccionados().contains(p)){
						JOptionPane.showMessageDialog(getParent(), "Ya existe un usuario con ese nombre" );
						salida=true;
					}
					if (salida==false){
						ManejadorComienzoPartida.instance().getListaDePerfilesNoSeleccionados().add(p);
						ManejadorComienzoPartida.instance().getListaDePerfilesPersistidos().add(p);
						lbUsuarios.removeAll();
						lbUsuarios.setListData(ManejadorComienzoPartida.instance().getListaDePerfilesNoSeleccionados().toArray());
						tbNombre.setText(null);
						
					}
					}
					else{
						JOptionPane.showMessageDialog(getParent(), "Verifique los datos" );
					}
				
				
				
			}
		});
		btnCrearPerfilDe.setText("Crear Perfil de Usuario");
		btnCrearPerfilDe.setBounds(new Rectangle(14, 357, 165, 27));
		contentPane.add(btnCrearPerfilDe);
		
		JLabel lblUsuariosAgregadosA = new JLabel();
		lblUsuariosAgregadosA.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUsuariosAgregadosA.setText("Usuarios de la partida");
		lblUsuariosAgregadosA.setBounds(new Rectangle(14, 16, 142, 16));
		lblUsuariosAgregadosA.setBounds(459, 16, 153, 16);
		contentPane.add(lblUsuariosAgregadosA);
		
		
		
		JLabel lblCracinDeNuevo = new JLabel();
		lblCracinDeNuevo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCracinDeNuevo.setText("Craci\u00F3n de nuevo Usuario");
		lblCracinDeNuevo.setBounds(new Rectangle(14, 16, 142, 16));
		lblCracinDeNuevo.setBounds(14, 245, 185, 16);
		contentPane.add(lblCracinDeNuevo);
		
		JButton btnComenzarPartida = new JButton();
		btnComenzarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameMaster master = GameMaster.instance();
				MainWindow window = new MainWindow();
				GameBoard gameBoard = new GameBoardFull();
				master.setGameBoard(gameBoard);				
				
				int jugadores=ManejadorComienzoPartida.instance().getListaDePerfilesSeleccionados().size();
				
				if(jugadores>1){
				
				GameMaster.instance().setNumberOfPlayers(jugadores);
				
				for(int i = 0; i < jugadores; i++) {
					
					GameMaster.instance().getPlayer(i).setName(ManejadorComienzoPartida.instance().getListaDePerfilesSeleccionados().get(i).getNombreDeUsuario());
				}
				window.setupGameBoard(gameBoard);
				window.show();
				master.setGUI(window);
				master.startGame();
				}else{
					
					JOptionPane.showMessageDialog(getParent(), "Por lo menos deben haber 2 jugadores para iniciar la partida" );
					
				}
			}
		});
		btnComenzarPartida.setText("Comenzar Partida");
		btnComenzarPartida.setBounds(new Rectangle(249, 125, 165, 27));
		btnComenzarPartida.setBounds(421, 357, 142, 27);
		contentPane.add(btnComenzarPartida);
		
		JButton btnQuitarDePartida = new JButton();
		btnQuitarDePartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Perfil p =(Perfil) lbUsuariosPartida.getSelectedValue();
				
				
				if(p!=null){
				
				String color= p.getColorFicha();
				System.out.println(color);
				cbColor.addItem(color);
				
				ManejadorComienzoPartida.instance().getListaDePerfilesNoSeleccionados().add(p);
				ManejadorComienzoPartida.instance().getListaDePerfilesSeleccionados().remove(p);
				lbUsuarios.setListData(ManejadorComienzoPartida.instance().getListaDePerfilesNoSeleccionados().toArray());
				lbUsuariosPartida.setListData(ManejadorComienzoPartida.instance().getListaDePerfilesSeleccionados().toArray());
			    }else{
					JOptionPane.showMessageDialog(getParent(), "Seleccione un usuario" );
				}
				
				
			}
		});
		btnQuitarDePartida.setText("<- Quitar de partida ");
		btnQuitarDePartida.setBounds(new Rectangle(162, 43, 136, 26));
		btnQuitarDePartida.setBounds(289, 130, 160, 26);
		contentPane.add(btnQuitarDePartida);
		
		JButton btnEliminarUsuario = new JButton();
		btnEliminarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Perfil p=(Perfil) lbUsuarios.getSelectedValue();
				if (p!=null){
				ManejadorComienzoPartida.instance().getListaDePerfilesNoSeleccionados().remove(p);
				ManejadorComienzoPartida.instance().getListaDePerfilesPersistidos().remove(p);
				lbUsuarios.setListData(ManejadorComienzoPartida.instance().getListaDePerfilesNoSeleccionados().toArray());
				}else{
					
					JOptionPane.showMessageDialog(getParent(), "Seleccione un usuario" );
				}
				
			}
		});
		btnEliminarUsuario.setText("Eliminar Usuario");
		btnEliminarUsuario.setBounds(new Rectangle(404, 224, 165, 27));
		btnEliminarUsuario.setBounds(14, 167, 146, 27);
		contentPane.add(btnEliminarUsuario);
		
		JButton btnCambiarImagen = new JButton();
		btnCambiarImagen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Perfil p=(Perfil) lbUsuarios.getSelectedValue();
				if (p!=null){
				
				JFileChooser file = new JFileChooser();
		          file.setCurrentDirectory(new File(System.getProperty("user.home")));
		          //filter the files
		          FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
		          file.addChoosableFileFilter(filter);
		          int result = file.showSaveDialog(null);
		           //if the user click on save in Jfilechooser
		          if(result == JFileChooser.APPROVE_OPTION){
		              File selectedFile = file.getSelectedFile();
		              String path = selectedFile.getAbsolutePath();
		             p.setImagen(ResizeImage(path,lblImagen));
		             lblImagenUsuario.setIcon(p.getImagen());
		          }
		           //if the user click on save in Jfilechooser


		          else if(result == JFileChooser.CANCEL_OPTION){
		              System.out.println("No File Select");
		          }
				}else{
					
					JOptionPane.showMessageDialog(getParent(), "Seleccione un usuario" );
				}
			}
		});
		btnCambiarImagen.setText("Cambiar Imagen");
		btnCambiarImagen.setBounds(new Rectangle(404, 224, 165, 27));
		btnCambiarImagen.setBounds(14, 205, 146, 27);
		contentPane.add(btnCambiarImagen);
		
		
		
		
		
	}
	
// Methode to resize imageIcon with the same size of a Jlabel
public ImageIcon ResizeImage(String ImagePath, JLabel l)
{
    ImageIcon MyImage = new ImageIcon(ImagePath);
    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(l.getWidth(), l.getHeight(), Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
  
}
	
}
