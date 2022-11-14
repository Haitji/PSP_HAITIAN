package AEV2;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Lanzadora extends JFrame {

	private JPanel contentPane;
	public Process p;
	public JSpinner spinner_jamon;
	public JSpinner spinner_pollo;
	public JSpinner spinner_bacalao;
	public JSpinner spinner_queso;
	JSpinner spinner_p_jamon;
	JSpinner spinner_p_pollo;
	JSpinner spinner_p_bacalao;
	JSpinner spinner_p_queso;
	private long time_start, time_end;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lanzadora frame = new Lanzadora();
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
	public Lanzadora() {
		setTitle("Lanzadora");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 567, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Jamón: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(31, 169, 89, 35);
		contentPane.add(lblNewLabel);
		
		JLabel lblPollo = new JLabel("Pollo: ");
		lblPollo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPollo.setBounds(31, 214, 89, 35);
		contentPane.add(lblPollo);
		
		JLabel lblBacalao = new JLabel("Bacalao: ");
		lblBacalao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblBacalao.setBounds(31, 259, 89, 35);
		contentPane.add(lblBacalao);
		
		JLabel lblQueso = new JLabel("Queso: ");
		lblQueso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQueso.setBounds(31, 304, 89, 35);
		contentPane.add(lblQueso);
		
		spinner_jamon = new JSpinner();
		spinner_jamon.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinner_jamon.setEditor(new JSpinner.DefaultEditor(spinner_jamon));
		spinner_jamon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner_jamon.setBounds(130, 169, 68, 35);
		contentPane.add(spinner_jamon);
		
		spinner_pollo = new JSpinner();
		spinner_pollo.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinner_pollo.setEditor(new JSpinner.DefaultEditor(spinner_pollo));
		spinner_pollo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner_pollo.setBounds(130, 214, 68, 35);
		contentPane.add(spinner_pollo);
		
		spinner_bacalao = new JSpinner();
		spinner_bacalao.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinner_bacalao.setEditor(new JSpinner.DefaultEditor(spinner_bacalao));
		spinner_bacalao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner_bacalao.setBounds(130, 259, 68, 35);
		contentPane.add(spinner_bacalao);
		
		spinner_queso = new JSpinner();
		spinner_queso.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
		spinner_queso.setEditor(new JSpinner.DefaultEditor(spinner_queso));
		spinner_queso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner_queso.setBounds(130, 304, 68, 35);
		contentPane.add(spinner_queso);
		
		
		
		JButton btnNewButton = new JButton("Enviar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Recogemos todos los valores y se lo enviamos a la función de
				//crearProceso
				int jamon=(int)spinner_jamon.getValue();
				int pollo=(int)spinner_pollo.getValue();
				int bacalao=(int)spinner_bacalao.getValue();
				int queso=(int)spinner_queso.getValue();
				int p_jamon=(int)spinner_p_jamon.getValue();
				int p_pollo=(int)spinner_p_pollo.getValue();
				int p_bacalao=(int)spinner_p_bacalao.getValue();
				int p_queso=(int)spinner_p_queso.getValue();
				if(comprobarCantidadCroqueta()) {
					crearProceso(jamon,pollo,bacalao,queso,p_jamon,p_pollo,p_bacalao,p_queso);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(31, 349, 332, 40);
		contentPane.add(btnNewButton);
		
		JLabel lblCantidad = new JLabel("Cantidad ");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCantidad.setBounds(95, 107, 110, 35);
		contentPane.add(lblCantidad);
		
		JLabel lblPrioridad = new JLabel("Prioridad");
		lblPrioridad.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblPrioridad.setBounds(273, 107, 118, 35);
		contentPane.add(lblPrioridad);
		
		spinner_p_jamon = new JSpinner();
		spinner_p_jamon.setModel(new SpinnerNumberModel(4, 0, 4, 1));
		spinner_p_jamon.setEditor(new JSpinner.DefaultEditor(spinner_p_jamon));
		spinner_p_jamon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner_p_jamon.setBounds(295, 169, 68, 35);
		contentPane.add(spinner_p_jamon);
		
		spinner_p_pollo = new JSpinner();
		spinner_p_pollo.setModel(new SpinnerNumberModel(4, 0, 4, 1));
		spinner_p_pollo.setEditor(new JSpinner.DefaultEditor(spinner_p_pollo));
		spinner_p_pollo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner_p_pollo.setBounds(295, 214, 68, 35);
		contentPane.add(spinner_p_pollo);
		
		spinner_p_bacalao = new JSpinner();
		spinner_p_bacalao.setModel(new SpinnerNumberModel(4, 0, 4, 1));
		spinner_p_bacalao.setEditor(new JSpinner.DefaultEditor(spinner_p_bacalao));
		spinner_p_bacalao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner_p_bacalao.setBounds(295, 259, 68, 35);
		contentPane.add(spinner_p_bacalao);
		
		spinner_p_queso = new JSpinner();
		spinner_p_queso.setModel(new SpinnerNumberModel(4, 0, 4, 1));
		spinner_p_queso.setEditor(new JSpinner.DefaultEditor(spinner_p_queso));
		spinner_p_queso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spinner_p_queso.setBounds(295, 304, 68, 35);
		contentPane.add(spinner_p_queso);
		
		JLabel lblNewLabel_1 = new JLabel("<html>Cuando menor sea el numero<br>mayor es la prioridad</html>");
		lblNewLabel_1.setBounds(392, 180, 140, 53);
		contentPane.add(lblNewLabel_1);
	}
	
	
	/**
	 * Método que ejecuta la clase procesadora pasandole la información por args
	 * @param jamon cantidad de croquetas
	 * @param pollo	---
	 * @param bacalao ---
	 * @param queso ---
	 * @param p_jamon prioridad de la croqueta
	 * @param p_pollo ---
	 * @param p_bacalao ---
	 * @param p_queso ---
	 */
	public void crearProceso(int jamon,int pollo,int bacalao,int queso,int p_jamon,int p_pollo,int p_bacalao,int p_queso) {
		try {
			String clase = "AEV2.Procesadora";
			String javaHome = System.getProperty("java.home");
			String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
			String classpath = System.getProperty("java.class.path");
			String className = clase;
			List<String> command = new ArrayList<>();
			command.add(javaBin);
			command.add("-cp");
			command.add(classpath);
			command.add(className);
			command.add(String.valueOf(jamon));
			command.add(String.valueOf(pollo));
			command.add(String.valueOf(bacalao));
			command.add(String.valueOf(queso));
			command.add(String.valueOf(p_jamon));
			command.add(String.valueOf(p_pollo));
			command.add(String.valueOf(p_bacalao));
			command.add(String.valueOf(p_queso));
			ProcessBuilder builder = new ProcessBuilder(command);
			//Recogemos la hora antes de inicializar el proceso
			time_start = System.currentTimeMillis();
			try {
				p = builder.inheritIO().start();
				p.waitFor();
				//Usamos el witFor para que espere a que se termine el proceso antes de recoger de nuevo la hora
				time_end = System.currentTimeMillis();
				JOptionPane.showMessageDialog(null, "Croquetas finalizado");
				JOptionPane.showMessageDialog(null, "Tiempo de fabricacion "+ ( time_end - time_start )/1000 +" seconds");
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Comprueba que el numero de croquetas recogido sea multiplo de 6
	 * Aunque tambien podriamos haber hecho que incremente de 6 en 6
	 * @return retorna true si todos las croquetas son multiplo de 6
	 */
	public boolean comprobarCantidadCroqueta() {
		if(((int)spinner_jamon.getValue()%6)!=0) {
			JOptionPane.showMessageDialog(null, "La cantidad croquetas de jamón debe ir de 6.");
			return false;
		}else if(((int)spinner_pollo.getValue()%6)!=0) {
			JOptionPane.showMessageDialog(null, "La cantidad croquetas de pollo debe incrementarse ir de 6.");
			return false;
		}else if(((int)spinner_bacalao.getValue()%6)!=0) {
			JOptionPane.showMessageDialog(null, "La cantidad croquetas de bacalao debe incrementarse ir de 6.");
			return false;
		}else if(((int)spinner_queso.getValue()%6)!=0) {
			JOptionPane.showMessageDialog(null, "La cantidad croquetas de queso debe incrementarse ir de 6.");
			return false;
		}else {
			return true;
		}
	}
}
