package Principal;

/**
 * @author Daniel Simón Mateo
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class VentanaPrincipal {
	private JFrame ventana;
	private JPanel panelSuperior;
	private JPanel panelProgreso;
	private JPanel panelControl;
	private JPanel panelText;
	private MiBoton[] botones;
	JProgressBar barraProgreso;
	JTextField campoTexto;

	public VentanaPrincipal() {
		ventana = new JFrame();
		ventana.setBounds(0, 0, 600, 800);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		botones = new MiBoton[5];
	}

	public void inicializarComponentes() {
		String[] nombreBotones = { "Flujo", "Uranio", "Electricidad", "Motores", "Gas Vespeno" };

		ventana.setLayout(new GridBagLayout());
		GridBagConstraints settings = new GridBagConstraints();

		// configuración del panel superior
		settings = new GridBagConstraints();
		panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.DARK_GRAY);
		settings.fill = GridBagConstraints.BOTH;
		settings.weighty = 1;
		settings.gridwidth = 2;
		panelSuperior.setBorder(BorderFactory.createLineBorder(Color.black));
		ventana.add(panelSuperior, settings);

		// configuración del panel de control
		settings = new GridBagConstraints();
		// settings.anchor = GridBagConstraints.CENTER;
		panelControl = new JPanel();
		panelControl.setLayout(new GridBagLayout());
		panelControl.setBackground(Color.CYAN);
		panelControl.setBorder(BorderFactory.createTitledBorder("Control"));

		// añadimos los botones al panel de control
		for (int i = 0; i < botones.length; i++) {
			botones[i] = new MiBoton(this);
			botones[i].setText(nombreBotones[i]);
			panelControl.add(botones[i]);
		}

		settings.ipadx = 50;
		settings.ipady = 50;
		panelSuperior.add(panelControl, settings);

		// configuración del panel de progreso
		settings = new GridBagConstraints();
		panelProgreso = new JPanel();
		panelProgreso.setBackground(Color.LIGHT_GRAY);
		settings.weighty = 1;
		settings.weightx = 1;
		settings.gridx = 0;
		settings.gridy = 1;
		settings.fill = GridBagConstraints.BOTH;
		panelProgreso.setBorder(
				BorderFactory.createCompoundBorder(new EmptyBorder(20, 20, 20, 20), new TitledBorder("Progreso")));
		ventana.add(panelProgreso, settings);

		// configuración de la barra de progreso
		settings = new GridBagConstraints();
		barraProgreso = new JProgressBar(0,100);
		barraProgreso.setValue(50);
		barraProgreso.setStringPainted(true);
		settings.ipady = 500;
		panelProgreso.add(barraProgreso);

		// configuración del panel con JTextField
		settings = new GridBagConstraints();
		panelText = new JPanel();
		panelText.setLayout(new GridBagLayout());
		panelText.setBackground(Color.black);
		panelText.setBorder(
				BorderFactory.createCompoundBorder(new EmptyBorder(20, 20, 20, 20), new LineBorder(Color.white)));
		settings.weightx = 1;
		settings.weighty = 1;
		settings.fill = GridBagConstraints.BOTH;
		settings.gridx = 1;
		settings.gridy = 1;
		ventana.add(panelText, settings);

		// configuracion del JTextPanel
		settings = new GridBagConstraints();
		campoTexto = new JTextField();
		campoTexto.setEditable(false);
		settings.weightx = 1;
		settings.weighty = 1;
		settings.fill = GridBagConstraints.BOTH;
		panelText.add(campoTexto, settings);

	}

	public MiBoton[] retornarBotones() {
		return botones;
	}

	public void inicializar() {
		inicializarComponentes();
		ventana.setVisible(true);
	}

}
