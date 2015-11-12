/**
 Copyright 2015 Michael Xing

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at

  http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and
 limitations under the License.

 Rock Paper Scissors 101
 @author Michael Xing
 @version 11/10/2015
 */
import java.util.Scanner;
import java.net.*;
import java.io.*;

public class RPSOneHundred{

	public static final int TOTAL_MOVES = 101;
	public static final int CHEAT_CODE = 42;

	/**
	 Actual game logic - will loop through the game and ask for moves; anything other then an integer
	 will abort the game. Also tracks wins and losses.
	 */
	public static void main(String[] args){

		//Clear the screen
		System.out.print("\033[H\033[2J");
    	System.out.flush();

		//Set up the text stuff
		System.out.println("");
		System.out.println("");
		System.out.println("RRRRRRRRRRRRRRRRR   PPPPPPPPPPPPPPPPP      SSSSSSSSSSSSSSS        1111111        000000000       1111111   ");
		System.out.println("R::::::::::::::::R  P::::::::::::::::P   SS:::::::::::::::S      1::::::1      00:::::::::00    1::::::1   ");
		System.out.println("R::::::RRRRRR:::::R P::::::PPPPPP:::::P S:::::SSSSSS::::::S     1:::::::1    00:::::::::::::00 1:::::::1   ");
		System.out.println("RR:::::R     R:::::RPP:::::P     P:::::PS:::::S     SSSSSSS     111:::::1   0:::::::000:::::::0111:::::1   ");
		System.out.println("  R::::R     R:::::R  P::::P     P:::::PS:::::S                    1::::1   0::::::0   0::::::0   1::::1   ");
		System.out.println("  R::::R     R:::::R  P::::P     P:::::PS:::::S                    1::::1   0:::::0     0:::::0   1::::1   ");
		System.out.println("  R::::RRRRRR:::::R   P::::PPPPPP:::::P  S::::SSSS                 1::::1   0:::::0     0:::::0   1::::1   ");
		System.out.println("  R:::::::::::::RR    P:::::::::::::PP    SS::::::SSSSS            1::::l   0:::::0 000 0:::::0   1::::l   ");
		System.out.println("  R::::RRRRRR:::::R   P::::PPPPPPPPP        SSS::::::::SS          1::::l   0:::::0 000 0:::::0   1::::l   ");
		System.out.println("  R::::R     R:::::R  P::::P                   SSSSSS::::S         1::::l   0:::::0     0:::::0   1::::l   ");
		System.out.println("  R::::R     R:::::R  P::::P                        S:::::S        1::::l   0:::::0     0:::::0   1::::l   ");
		System.out.println("  R::::R     R:::::R  P::::P                        S:::::S        1::::l   0::::::0   0::::::0   1::::l   ");
		System.out.println("RR:::::R     R:::::RPP::::::PP          SSSSSSS     S:::::S     111::::::1110:::::::000:::::::0111::::::111");
		System.out.println("R::::::R     R:::::RP::::::::P          S::::::SSSSSS:::::S     1::::::::::1 00:::::::::::::00 1::::::::::1");
		System.out.println("R::::::R     R:::::RP::::::::P          S:::::::::::::::SS      1::::::::::1   00:::::::::00   1::::::::::1");
		System.out.println("RRRRRRRR     RRRRRRRPPPPPPPPPP           SSSSSSSSSSSSSSS        111111111111     000000000     111111111111");
		System.out.println("");
		System.out.println("");
		System.out.println("By: Michael Xing");
		System.out.println("Copyright 2015 - Apache v2");
		System.out.println("For more information, see the README file.");
		System.out.println("");
		System.out.println("----------------------------------------");
		System.out.println("");
		System.out.println("To play, enter a number from 1 to " + TOTAL_MOVES);
		System.out.println("To quit, type anything else");
		System.out.println("");
		System.out.println("----------------------------------------");
		System.out.println("");

		boolean temp = false;
		boolean playing = true;
		int win = 0;
		int loose = 0;

		Scanner keyboard = new Scanner(System.in);
		char response;

		while(playing){
			if(temp){
				System.out.println("----------------------------------------");
				System.out.println("");
				System.out.println("Wins: " + win + " - Losses: " + loose);
				System.out.println("");
				System.out.print("Enter your next move to play again, or type anything else to quit:: ");
			} else{
				temp = true;
				System.out.print("Enter your move:: ");
			}


			int e;

			try{
				e = Integer.parseInt(keyboard.next());

				switch(playGame(e)){
					case 0: loose++;break;
					case 1: win++;	break;
				}
			} catch(Exception z){
				playing = false;
			}


			System.out.println("");
		}
	}

	/**
	 Plays the actual game. Runs game logic and prints out the results to screen.
	 @param e The integer representing the player's move
	 @return 0 if the player looses, 1 if the player wins, and 9 if anything else (draw / error) happens
	 */
	public static int playGame(int e){
		e--;


		if(!(e >= 0 && e < TOTAL_MOVES)){
			return 9;
		}

		int c = (int)(Math.random() * TOTAL_MOVES);
		if(e == (CHEAT_CODE - 1)){
			c = (int)(Math.random() * 40) + CHEAT_CODE;
		}//Michael was here

		System.out.println();

		if(e == c){
			System.out.println("DRAW - You both had " + (e + 1));
			return 9;
		}

		for(int i = 1; i <= 50; i++){
			if(((e + i) % TOTAL_MOVES) == c){//WIN
				System.out.println("##      ## #### ##    ## ");
				System.out.println("##  ##  ##  ##  ###   ## ");
				System.out.println("##  ##  ##  ##  ####  ## ");
				System.out.println("##  ##  ##  ##  ## ## ## ");
				System.out.println("##  ##  ##  ##  ##  #### ");
				System.out.println("##  ##  ##  ##  ##   ### ");
				System.out.println(" ###  ###  #### ##    ## ");
				System.out.println("");
				System.out.println("(computer had "+ (c + 1) + ")");
				System.out.println("Your " + returnWeapon(e) + " " + returnCombo(e, c));
				return 1;
			}
		}

		System.out.println("  _        ___    ____    _____ ");
		System.out.println(" | |      / _ \\  / ___|  | ____|");
		System.out.println(" | |     | | | | \\___ \\  |  _|  ");
		System.out.println(" | |___  | |_| |  ___) | | |___ ");
		System.out.println(" |_____|  \\___/  |____/  |_____|");
		System.out.println("");//LOSE
		System.out.println("(computer had "+ (c + 1) + ")");
		System.out.println("The computer's " + returnWeapon(c) + " " + returnCombo(c, e));
		return 0;
	}

	/**
	 Processes the contents of the website and returns the subject
	 @param a The integer representing the move
	 @return The string representing the move
	 */
	public static String returnWeapon(int a){
		try{
			String temp = websiteOpener(a + 1);
			return temp.split("<title=\"RPS-" + TOTAL_MOVES + " on umop.com - ")[1].split("\"")[0].toLowerCase();
		} catch(Exception e){
			return "";
		}
	}

	/**
	 Processes the contents of the website and returns the verb and
	 the object of the sentence
	 @param a The integer representing the winning move
	 @param b The integer representing the losing move
	 @return The string representing the verb and the losing move
	 */
	public static String returnCombo(int a, int b){//Only works if beats b
		try{

			String temp = websiteOpener(a + 1);
			String returnStatement;

			if(a == (b - 1)){//In case it's the first one in the table
				returnStatement = temp.split("<td>")[1];
				returnStatement = returnStatement.split("/n")[1];
				returnStatement = returnStatement.split("</a>")[0];
				returnStatement = returnStatement.replaceAll("\\<[^>]*>","").toLowerCase();

			} else if(temp.split("\"" + b + ".htm\">")[1].split("/n")[1].charAt(0) != '<'){
				//------------------------------------------------------------
				//						GENERIC CASE
				//------------------------------------------------------------

				returnStatement = temp.split("\"" + b + ".htm\">")[1];
				returnStatement = returnStatement.split("/n")[1];
				returnStatement = returnStatement.replaceAll("\\<[^>]*>","");
				returnStatement = returnStatement.toLowerCase();

			} else if(temp.split("\"" + b + ".htm\">")[1].split("/n")[1].charAt(1) == '/'){
				//In case it snagged the bottom before a </td> whatever
				returnStatement = temp.split("\"" + b + ".htm\">")[1];
				returnStatement = returnStatement.split("/n")[3];
				returnStatement = returnStatement.split(" <a href=")[0];
				returnStatement = returnStatement.replaceAll("\\<[^>]*>","");
				returnStatement = returnStatement.toLowerCase();

			} else if(temp.split("\"" + b + ".htm\">")[1].charAt(1) == 'i'){
				//In case it managed to snag the back/forward image tag
				returnStatement = temp.split("\"" + b + ".htm\">")[2];
				returnStatement = returnStatement.split("/n")[1];
				returnStatement = returnStatement.replaceAll("\\<[^>]*>","");
				returnStatement = returnStatement.toLowerCase();

			} else if(temp.split("\"" + b + ".htm\">")[1].split("/n")[1].charAt(1) == 'a'){
				//In case it's one of those stupid things where the verb comes after the subject
				returnStatement = temp.split("\"" + b + ".htm\">")[1];
				returnStatement = returnStatement.split("/n")[1];
				returnStatement = returnStatement.replaceAll("\\<[^>]*>","");
				returnStatement = returnStatement.toLowerCase();

			} else {
				//Catch all error
				returnStatement = "\n----------\nERROR\n----------\n";
				returnStatement += "Malformed input from server\nDumping input below\n----------\n";
				returnStatement += temp.split("\"" + b + ".htm\">")[1]; //INPUT DUMP
				returnStatement +="\n\n----------\nERROR\n----------\nMalformed input from server\n";
				returnStatement += "If you could show this to me, that'd be great.\n----------\n";

			}
			return returnStatement;


		} catch(Exception e){
			return "";
		}
	}

	/**
	 Grabs the HTML content of the website and returns it
	 @param num The integer representing the move whose website to look up
	 @return The entire HTML content of the page from umop.com as a string.
	 */
	public static String websiteOpener(int num) throws Exception {

		String returnLine = "";

		URL oracle = new URL("http://www.umop.com/rps" + TOTAL_MOVES + "/" + num + ".htm");
		BufferedReader in = new BufferedReader(
		new InputStreamReader(oracle.openStream()));

		String inputLine;
		while ((inputLine = in.readLine()) != null){
			returnLine += inputLine + "/n";
		}
		in.close();

		return returnLine;
	}

}
