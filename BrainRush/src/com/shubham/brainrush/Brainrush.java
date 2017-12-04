
package com.shubham.brainrush;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Shubham Agrawal
 *
 */
public class Brainrush {

	private Game Game_obj;
	private Sound background_music = new Sound();

	// constructor to initialize window
	public Brainrush()throws Exception
	{
		background_music.music();
		JFrame frame = new JFrame( "BRAIN RUSH" );
		Game_obj = new Game();
		frame.add( Game_obj );
		frame.setSize( 700, 700 );
		frame.setVisible( true );

		//Closing of window
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	public static void main(String[] args) throws Exception {

		int speed = 35;
		String String_obj = "";
		Brainrush Brainrush_obj = new Brainrush();

		while( true ) {

			while( true ) {

				try {
					Brainrush_obj.Game_obj.moveBall();
					Brainrush_obj.Game_obj.moveBall();
					Brainrush_obj.Game_obj.moveBall();
					Brainrush_obj.Game_obj.moveBall();
					Brainrush_obj.Game_obj.moveBall();
					Brainrush_obj.Game_obj.moveBall();
					Brainrush_obj.Game_obj.moveBall();
				}
				catch ( Exception e ) {
					break;
				}

				Brainrush_obj.Game_obj.repaint();
				speed=28;

				if( Brainrush_obj.Game_obj.score > 5 && Brainrush_obj.Game_obj.score <= 10 )
					speed = 25;

				if( Brainrush_obj.Game_obj.score > 10 && Brainrush_obj.Game_obj.score <= 15 )
					speed = 23;

				if( Brainrush_obj.Game_obj.score > 15 && Brainrush_obj.Game_obj.score <= 20 )
					speed = 21;

				if( Brainrush_obj.Game_obj.score > 20 && Brainrush_obj.Game_obj.score <= 30 )
					speed = 19;

				if( Brainrush_obj.Game_obj.score > 30 && Brainrush_obj.Game_obj.score <= 45 )
					speed = 18;

				if( Brainrush_obj.Game_obj.score > 45 && Brainrush_obj.Game_obj.score <= 60 )
					speed = 17;

				if( Brainrush_obj.Game_obj.score > 60 && Brainrush_obj.Game_obj.score <= 80 )
					speed = 16;
					
				if( Brainrush_obj.Game_obj.score > 80 && Brainrush_obj.Game_obj.score <= 100 )
					speed = 15;

				if( Brainrush_obj.Game_obj.score > 100 && Brainrush_obj.Game_obj.score <= 150 )
					speed = 14;

				if( Brainrush_obj.Game_obj.score > 150 && Brainrush_obj.Game_obj.score <= 250 )
					speed = 13;

				if( Brainrush_obj.Game_obj.score > 250 )
					speed = 12;

				Thread.sleep( speed );

			}

			if( Brainrush_obj.Game_obj.score < 30 )
				String_obj = "@@@@@  BAD PLAYED  @@@@@";

			if( Brainrush_obj.Game_obj.score < 10 )
				String_obj = "@@@@@  LOOSER  @@@@@";

			if( Brainrush_obj.Game_obj.score >= 30 && Brainrush_obj.Game_obj.score < 50 )
				String_obj = "@@@@@  GOOD PLAYED  @@@@@";

			if( Brainrush_obj.Game_obj.score >= 50 && Brainrush_obj.Game_obj.score < 70 )
				String_obj = "@@@@@  NICE PLAYED  @@@@@";

			if( Brainrush_obj.Game_obj.score >= 70 && Brainrush_obj.Game_obj.score < 90 )
				String_obj = "@@@@@  AWESOME  @@@@@";

			if( Brainrush_obj.Game_obj.score >= 90 && Brainrush_obj.Game_obj.score < 110 )
				String_obj = "@@@@@  CONGRATULATIONS  @@@@@\n@@@@  YOU GOT BRONZE MEDAL  @@@@";

			if( Brainrush_obj.Game_obj.score >= 110 && Brainrush_obj.Game_obj.score < 130 )
				String_obj = "@@@@@  CONGRATULATIONS  @@@@@\n@@@@  YOU GOT SILVER MEDAL  @@@@";

			if(Brainrush_obj.Game_obj.score >= 130 && Brainrush_obj.Game_obj.score < 180 )
				String_obj = "@@@@@  CONGRATULATIONS  @@@@@\n@@@@  YOU GOT GOLD MEDAL  @@@@";

			if(Brainrush_obj.Game_obj.score >= 180)
				String_obj = "@@@@  YOU ARE THE SON OF GOD  @@@@";

			Brainrush_obj.Game_obj.restart = JOptionPane.showConfirmDialog( Brainrush_obj.Game_obj, "Your Score is [  " + Brainrush_obj.Game_obj.score + "  ]\n\n" + String_obj + "\n" + "  \n\nDo you want to restart?" );

			if( Brainrush_obj.Game_obj.restart == 0 )
			{
				Brainrush_obj = new Brainrush();
			}
			else
				System.exit( 0 );

		}
	}
}