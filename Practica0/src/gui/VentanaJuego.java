package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import datos.Coche;

public class VentanaJuego extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel pCentral,pSur;
	private JButton bAcelera,bFrena,bGiraIzq,bGiraDer;
	
	public VentanaJuego () {
		JFrame ventana = this;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		
		Coche c1 = new Coche();
		c1.setPosX(150);
		c1.setPosY(100);
		System.out.println(c1.toString());
		
		LabelCoche lc = new LabelCoche();
		lc.setLocation((int)c1.getPosX(), (int)c1.getPosY());
		
		pCentral = new JPanel();
		pSur = new JPanel();
		
		bAcelera = new JButton("Acelera");
		bFrena = new JButton("Frena");
		bGiraDer = new JButton("Gira Izq.");
		bGiraIzq = new JButton("Gira Der.");
		
		
		pCentral.setBackground(Color.WHITE);
		pCentral.add(lc);
		
		pSur.add(bAcelera);
		pSur.add(bFrena);
		pSur.add(bGiraDer);
		pSur.add(bGiraIzq);

		
		getContentPane().add(pSur,BorderLayout.SOUTH);
		getContentPane().add(pCentral,BorderLayout.CENTER);
		
		
		bGiraIzq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				c1.giro(3);
				
			}
		});
		
		bGiraDer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				c1.giro(-3);
				
			}
		});
		
		
		bFrena.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(c1.getMiVelocidad()>0)
					c1.acelera(-0.5);
				
			}
		});
		
		bAcelera.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				c1.acelera(0.5);
				
				
			}
		});
		
		new Thread() {
			@Override
			public void run() {
				boolean estado = true;
				while(estado) {
					c1.mueve(1);
					lc.setLocation((int)c1.posX,(int)c1.posY);
					System.out.println(c1.getPosX()+" : "+c1.getPosY());
					try {
						Thread.sleep(40);}catch (InterruptedException e) {
						System.err.println(e);
						}
				}
			}
			
		}.start();
		setVisible(true);
	}
	public static void main(String[] args) {
		VentanaJuego vj = new VentanaJuego();
		
		
	}
	
	
	

}
