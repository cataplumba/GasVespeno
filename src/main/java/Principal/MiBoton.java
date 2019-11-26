package Principal;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class MiBoton extends JButton implements MouseListener {
	VentanaPrincipal ventana;
	
	public MiBoton(VentanaPrincipal ventana) {
		super();
		this.addMouseListener(this);
		this.ventana = ventana;
	}

	public void mouseClicked(MouseEvent arg0) {
		
	}

	public void mouseEntered(MouseEvent e) {
		
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		int botonesPulsados=0;
		String ultimoBotonPulsado = this.getText();
		
		if(this.getForeground()==Color.red) {
			this.setForeground(Color.black);
		}else {
			this.setForeground(Color.red);
		}
		
		MiBoton[]botones = ventana.retornarBotones();
		for (int i = 0; i < botones.length; i++) {
			if(botones[i].getForeground()==Color.red) {
				botonesPulsados++;
			}
		}
		
		ventana.campoTexto.setText("["+botonesPulsados+"]"+ultimoBotonPulsado);
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
