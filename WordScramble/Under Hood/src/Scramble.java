import java.util.*;


public class Scramble {

	public static void main(String[] args) {
		
		int randInt;
		String first;
		String middle = "";
		String last;
		String word = "";
		String used = "";
		Random rand = new Random();
		
		//Takes a input stream - this will be different in the android app
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the String that you want to be scrambled: ");
		
		//scrambleString has the entire string that was entered
		String scrambleString = scanner.nextLine();
		
		//This scanner is used to break down the string into tokens, or words in this case
		Scanner tokenizer = new Scanner(scrambleString);
		String finalString = "";
		
		//String builders are used to append each new token as the new scrambled string is constructed.
		StringBuilder stringbuilder = new StringBuilder();
		//This StringBuilder is used to ensure that the random letters chosen are not the same letter.
		//Future problem to be dealth with - how to deal with words longer than 13 letters?
		StringBuilder usedbuilder = new StringBuilder();
		
		
		//While there are more words
		while(tokenizer.hasNext()){
			
			//get word
			word = tokenizer.next();
			
			
			//if word is longer than 3 characters - this is because it is impossible to scramble a word of less than
			//3 characters while keeping the first and last letters intact
			if(word.length() > 3){
				
				
				first = word.substring(0,1);		//holds first letter of word
				middle = word.substring(1, word.length()-1); 	//holds middle part that will be scrambled
				last = word.substring((word.length()-1), word.length());	//holds last letter of the word
				
				
				stringbuilder.append(first);
				
				//add as many characters to the string builder that exist in the string "middle"
				for(int i = 0; i < middle.length(); i++){
					
					
					//create a random integer based on ASCII CHAR TABLE
					randInt = (rand.nextInt(middle.length()) + 33); //ASCII code 33 and up allow for characters that are
																	//acceptable such as punctuation, A-Za-z0-9
					
					//makes sure a particular index hasn't already been added
					while((usedbuilder.indexOf((String.valueOf((char)randInt))))>=0){
						
						randInt = (rand.nextInt(middle.length()) + 33);
						//System.out.println((char)randInt);

					}
					
					usedbuilder.append(String.valueOf((char)randInt));
					String temp = "";
					temp = middle.substring((randInt-33),((randInt+1)-33));	//add one of the letters - 33 is subtracted so that the number
					stringbuilder.append(temp);								//is a valid index in the word.
					
					
				}
				
				//after all of the middle letters have been added back, add the last letter and a space 
				//and start the process over.
				stringbuilder.append(last);
				stringbuilder.append(" ");
				
				//clear usedbuilder so that a new set of integers can be tracked.
			    usedbuilder.delete(0, usedbuilder.length());
				
			}
			
			//If the word is 3 characters or fewer, simply append the word as it is.
			else{
			
				stringbuilder.append(word + " ");
				
			}
		
		}
		
		
		//FINALLY, build the string and then output it to the user. Once again, this will be different slightly
		//in the actual android app.
		finalString = stringbuilder.toString();
		System.out.println(finalString);
		

	}

}
