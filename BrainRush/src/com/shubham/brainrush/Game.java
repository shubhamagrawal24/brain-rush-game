
package com.shubham.brainrush;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * @author Shubham Agrawal
 *
 */
@SuppressWarnings("serial")
public class Game extends JPanel {

	int restart = 1, x_axis = 650, y_axis = 300, mouse_flag = 1, score, object_flag, direction_flag = 4;

	// create Objects of Classes

//	private String String_obj = "";
	private Color Color_obj;
	private Label score_label1, score_label2;
	private Image background_image;
	private Font score_font;
	private Sound beep_sound = new Sound();
	
	public File img_file;
	public Graphics Graphics_obj;

	// constructor to initialize game
	public Game() {

		super();

		score = 0;
		Graphics_obj=getGraphics();
		score_font = new Font( "Serif", Font.PLAIN, 16 );

		try {
			background_image = ( Image )ImageIO.read( ClassLoader.getSystemResource( "Circle.jpg" ) );
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// create Label for Score
		score_label1 = new Label( "Score", Label.CENTER );
		score_label2 = new Label( "" + 0, Label.CENTER );

		// set the score font
		score_label1.setFont( score_font );
		score_label2.setFont( score_font );

		setLayout( null );

		score_label2.setBounds( 600, 20, 50, 40 );
		score_label1.setBounds( 500, 20, 100, 40 );

		// set the background color
		score_label1.setBackground( Color.RED );
		score_label2.setBackground( Color.YELLOW );

		// add labels on panel
		add( score_label1 );
		add( score_label2 );

		// set size of panel
		setSize( 700, 750 );

		// method to mouse handling
		/**
		 * 
		 */
		addMouseListener( new MouseAdapter() {

			// method to get Oval
			public void mousePressed( MouseEvent e ) {
				mouse_flag = 0;
				repaint();
			}

			// method to get Rectangle
			public void mouseReleased( MouseEvent e ) {
				mouse_flag = 1;
				repaint();
			}

		});
	}

	// method to move the Object
	/**
	 * 
	 */
	public void moveBall() throws Exception {

		// object moves from Up to Down
		if( direction_flag == 1 ) {

			y_axis = y_axis + 1;
			x_axis = 300;

			if( y_axis == 280 )
				matchObject();

			if( y_axis == 300 )
				createNewObject();

		 }

		// object moves from Left to Right
		if( direction_flag == 2 ) {

			x_axis = x_axis + 1;
			y_axis = 300;

			if( x_axis == 280)
				matchObject();

		 	if( x_axis == 300)
		 		createNewObject();

		}

		// object moves from Down to up
		if( direction_flag == 3 ) {

			y_axis = y_axis - 1;
			x_axis = 300;

			if( y_axis == 320 )
				matchObject();

			if( y_axis == 300)
				createNewObject();

		}

		// object moves from Right to Left
		if( direction_flag == 4 || direction_flag == 0 ) {

			x_axis = x_axis - 1;

			if( x_axis < 0 )
				x_axis = x_axis * ( -1 );

			y_axis = 300;

			if( x_axis == 320)
				matchObject();

		 	if( x_axis == 300)
		 		createNewObject();

		}
	}

	// method to create new moving object circle/square
	/**
	 * 
	 */
	private void createNewObject() {

		// generate random color for Object
		Color_obj = new Color( ( int )( Math.random() * 255 ),( int )( Math.random() * 255 ),( int )( Math.random() * 255 ) );

		// generate random 4 numbers for direction of moving oject
		direction_flag = ( int )( Math.random() * 5 );

		// switch case for direction of moving oject
		switch( direction_flag ) {

			case 1:
				y_axis = 1;
				break;

			case 2:
				x_axis = 1;
				break;

			case 3:
				y_axis = 650;
				break;

			case 4:
				x_axis = 650;
				break;

			default:
				x_axis = 650;

		}
	}

	// method to match object and increase score
	/**
	 * @throws Exception 
	 * 
	 */
	private void matchObject() throws Exception {

			// condition for checking Object match to Oval
			if( object_flag == 1 ) {

					if( mouse_flag == 0 ) {
						score ++;
						beep_sound.sound();
					}

					else throw ( new Exception() );
			}

			// condition for checking Object match to Rectangle
			else {

				if( mouse_flag == 1 ) {
					score ++;
					beep_sound.sound();
				}

			}

			score_label2.setText( "" + score );
	
			// generate random 2 numbers for Oval and Rectangle     	
			object_flag = ( int )( Math.random() * 2 );
		}

	/**
	 * paint() method to draw Objects
	 */
	public void paint( Graphics Graphics_obj ) {

		super.paint( Graphics_obj );

		Graphics2D g2d = ( Graphics2D ) Graphics_obj;
		int temp_object_flag = object_flag;

		// draw the Image as a background
		g2d.drawImage( background_image, 0, 0, 700, 700, null );
		g2d.setColor( Color_obj );

		// method to control rendering quality
		g2d.setRenderingHint( RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON );

		// condition for fill the Oval
		if( mouse_flag == 0 )
			g2d.fillOval( 300, 300, 50, 50 );

		// condition for fill the Rectangle
		if( mouse_flag == 1 )
			g2d.fillRect( 300, 300, 50, 50 );

		// switch case for fill object
		switch( temp_object_flag ) {

			case 0:
						g2d.fillRect( x_axis, y_axis, 50, 50 );
						break;

			case 1:
						g2d.fillOval( x_axis, y_axis, 50, 50 );
						break;

			default:
						g2d.fillOval( x_axis, y_axis, 50, 50 );

		}
	}
}