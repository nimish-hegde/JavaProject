/*------------------------------------------------------------------------------------------------------------------------------*/
/*  MP3Summative.java  - This program will let users manage their MP3 files                                                     */
/*                                                                                                                              */
/*------------------------------------------------------------------------------------------------------------------------------*/
/*  Author: Nimish Hegde                                                                                                        */
/*  Date: May 11th, 2015                                                                                                        */
/*------------------------------------------------------------------------------------------------------------------------------*/
/*  Input: The user tells the program which method they want to use                                                             */
/*  Output: The method requested is run and displayed to the user                                                               */
/*------------------------------------------------------------------------------------------------------------------------------*/
import java.io.*;
import java.util.*;
import java.text.*;

public class MP3Summative
{
    static BufferedReader stdin = new BufferedReader (new InputStreamReader (System.in));

    //First Method - Login prompt
    static void login (String name[], String song[], String artist[], String genre[], int counter[]) throws IOException
    {
	//Declare the variables needed
	String userName, pass, line = null;

	//If user is new or pre-existing who wants to access from the mother file
	System.out.println ("Welcome to the MP3 program, if you are a new user, please press n or N");
	System.out.println ("Press any other key to access the pre-existing/mother file");
	userName = stdin.readLine ();

	//If it is a new user, a username and password are created
	if (userName.equals ("n") || userName.equals ("N"))
	{
	    System.out.println ("What would you like to name your file?");
	    name [0] = stdin.readLine ();

	    BufferedWriter writer = new BufferedWriter (new FileWriter (name [0] + ".txt"));
	    System.out.println ("What would you like your password to be?");
	    pass = stdin.readLine ();
	    writer.write (pass);
	    writer.newLine ();
	    writer.close ();
	}
	//If pre-existing, then the program will access the mother/pre-existing file
	else
	{
	    name [0] = ("MP3Collection");
	    BufferedReader reader = new BufferedReader (new FileReader (name [0] + ".txt"));
	    while ((line = reader.readLine ()) != null)
	    {
		song [counter [0]] = line;
		artist [counter [0]] = reader.readLine ();
		genre [counter [0]] = reader.readLine ();

		counter [0]++;
	    }
	    reader.close ();
	}
    }


    //Second Method - To view the list of songs in the file
    static void view (String song[], String artist[], String genre[], int counter[]) throws IOException
    {
	int j = 0;
	String look;

	//Displaying the song, artist genre
	for (int i = 0 ; i < counter [0] ; i++)
	{
	    System.out.println ();
	    j++;
	    System.out.println ("" + song [i]);
	    j++;
	    System.out.println ("" + artist [i]);
	    j++;
	    System.out.println ("" + genre [i]);
	    j++;

	    //To make sure that the information will fit in the window
	    if (j % 900 == 0)
	    {
		System.out.println ();
		look = stdin.readLine ();
	    }
	}
    }


    //Third Method - Adding songs to the pre-existing collection
    static void addToCollection (String song[], String artist[], String genre[], int counter[], String name[]) throws IOException
    {

	BufferedWriter writer = new BufferedWriter (new FileWriter (name [0] + ".txt", true));

	//Declaring variable
	String response;

	do
	{
	    System.out.println ();

	    System.out.println ("What is the name of the song you would like to put in");
	    song [counter [0]] = stdin.readLine ();
	    writer.write (song [counter [0]]);
	    writer.newLine ();

	    System.out.println ("What is the name of the artist of that song");
	    artist [counter [0]] = stdin.readLine ();
	    writer.write (artist [counter [0]]);
	    writer.newLine ();

	    System.out.println ("What is the genre of that song");
	    genre [counter [0]] = stdin.readLine ();
	    writer.write (genre [counter [0]]);
	    writer.newLine ();

	    System.out.println ("Great! Your song has been added to the collection");

	    counter [0]++;

	    System.out.println ("");
	    System.out.println ("Do you wish to add any other songs, y for yes, any key to go back to main screen");
	    response = stdin.readLine ();

	}


	while (response.equals ("y"));

	writer.close ();
    }


    //Fourth Method - Search for a song by artist, song name or genre
    static void search (String[] song, String[] artist, String[] genre, int[] counter) throws IOException
    {
	String type, search;
	boolean found = false;
	int j = 0;

	//Ask the user how they want to search their song up
	System.out.println ("Would you like to search by song, artist or genre");
	type = stdin.readLine ();


	if (type.equals ("song") || type.equals ("Song"))
	{
	    //Ask the user what song they would like to look up
	    System.out.println ("Enter the name of the song you are looking for");
	    search = stdin.readLine ();

	    //A For loop which will analyze the array for particular song
	    for (int i = 0 ; i < counter [0] ; i++)
	    {
		//If the song is found, the song, artist and genre are shown to the user
		if (song [i].equals (search))
		{
		    System.out.println ();
		    j++;
		    System.out.println ("Song -" + song [i]);
		    j++;
		    System.out.println ("Artist -" + artist [i]);
		    j++;
		    System.out.println ("Genre -" + genre [i]);
		    j++;
		    System.out.println ();

		    //To make sure the information fits the screen
		    if (j % 900 == 0)
		    {
			System.out.println ();
		    }
		    found = true;
		}
	    }
	}

	//If the artist is found, the song, artist and genre are shown to the user
	else if (type.equals ("artist") || type.equals ("Artist"))
	{
	    System.out.println ("Enter the name of the artist you are looking for");
	    search = stdin.readLine ();

	    for (int i = 0 ; i < counter [0] ; i++)
	    {
		if (artist [i].equals (search))
		{
		    System.out.println ();
		    System.out.println ("song -" + song [i]);
		    System.out.println ("artist -" + artist [i]);
		    System.out.println ("genre -" + genre [i]);
		    System.out.println ();
		    found = true;
		}
	    }

	}

	//If the genre is found, the song, artist and genre are shown to the user
	else if (type.equals ("genre") || type.equals ("Genre"))
	{
	    System.out.println ("Enter the genre of the song you are looking for");
	    search = stdin.readLine ();

	    for (int i = 0 ; i < counter [0] ; i++)
	    {
		if (genre [i].equals (search))
		{
		    System.out.println ();
		    System.out.println ("song - " + song [i]);
		    System.out.println ("artist - " + artist [i]);
		    System.out.println ("genre - " + genre [i]);
		    System.out.println ();
		    found = true;
		}
	    }

	}

	//If the user input is not found, the program will display this message and loop it back to the main menu
	if (!found)
	{
	    System.out.println ("Sorry, you have entered an invalid command or ");
	    System.out.println ("What you are looking for has not been found in this collection");
	}
    }


    //Fifth method - Sort the songs in the file
    static void sort (String[] song, String[] artist, String[] genre, int[] counter, String[] name) throws IOException
    {
	BufferedWriter writer = new BufferedWriter (new FileWriter (name [0] + ".txt"));
	String sort, temp, temp2, temp3;
	boolean swapped;
	int l = 0;

	//Ask the user how they want their MP3's sorted
	System.out.println ("What would you like to sort by: song, artist, or genre");
	sort = stdin.readLine ();
	//Sorting by song alphabetically
	if (sort.equals ("song"))
	{
	    for (int i = 0 ; i < counter [0] - 1 ; i++)
	    {
		swapped = false;

		for (int j = 0 ; j < ((counter [0] - 1) - i) ; j++)
		{
		    if ((song [j].compareTo (song [j + 1])) > 0)
		    {
			temp = song [j];
			song [j] = song [j + 1];
			song [j + 1] = temp;

			temp2 = artist [j];
			artist [j] = artist [j + 1];
			artist [j + 1] = temp2;

			temp3 = genre [j];
			genre [j] = genre [j + 1];
			genre [j + 1] = temp3;

			swapped = true;
		    }
		}

		//Modified bubble sort
		if (!swapped)
		{
		    i = counter [0] - 1;
		}
	    }
	}

	//Sorting by artist alphabetically
	else if (sort.equals ("artist"))
	{
	    for (int i = 0 ; i < counter [0] - 1 ; i++)
	    {
		swapped = false;

		for (int j = 0 ; j < ((counter [0] - 1) - i) ; j++)
		{
		    if ((artist [j].compareTo (artist [j + 1])) > 0)
		    {
			temp = song [j];
			song [j] = song [j + 1];
			song [j + 1] = temp;

			temp2 = artist [j];
			artist [j] = artist [j + 1];
			artist [j + 1] = temp2;

			temp3 = genre [j];
			genre [j] = genre [j + 1];
			genre [j + 1] = temp3;

			swapped = true;
		    }
		}

		if (!swapped)
		{
		    i = counter [0] - 1;
		}
	    }
	}

	//Sorting by genre alphabetically
	else if (sort.equals ("genre") || sort.equals ("Genre"))
	{
	    for (int i = 0 ; i < counter [0] - 1 ; i++)
	    {
		swapped = false;

		for (int j = 0 ; j < ((counter [0] - 1) - i) ; j++)
		{
		    if ((genre [j].compareTo (genre [j + 1])) > 0)
		    {
			temp3 = genre [j];
			genre [j] = genre [j + 1];
			genre [j + 1] = temp3;

			temp2 = artist [j];
			artist [j] = artist [j + 1];
			artist [j + 1] = temp2;

			temp = song [j];
			song [j] = song [j + 1];
			song [j + 1] = temp;

			swapped = true;
		    }
		}
		if (!swapped)
		{
		    i = counter [0] - 1;
		}
	    }
	}

	System.out.println ();
	System.out.println ("Sorted song list:");

	//Displaying the sorted list
	for (int i = 0 ; i < counter [0] ; i++)
	{
	    System.out.println ();
	    l++;

	    System.out.println ("" + song [i]);
	    writer.write (song [i]);
	    writer.newLine ();
	    l++;

	    System.out.println ("" + artist [i]);
	    writer.write (artist [i]);
	    writer.newLine ();
	    l++;

	    System.out.println ("" + genre [i]);
	    writer.write (genre [i]);
	    writer.newLine ();
	    l++;

	    //this makes sure that the information fits the screen
	    if (l % 900 == 0)
	    {
		System.out.println ();
	    }
	}
	writer.close ();
    }


    //Sixth Method - Backup the file
    static void backup (String[] song, String[] artist, String[] genre, int[] counter, String[] name) throws IOException
    {
	//Creates a backup file
	BufferedWriter writer = new BufferedWriter (new FileWriter (name [0] + " (backup).txt"));

	//For loop to input all the song information into the backup file
	for (int i = 0 ; i < counter [0] ; i++)
	{
	    writer.write (song [i]);
	    writer.newLine ();

	    writer.write (artist [i]);
	    writer.newLine ();

	    writer.write (genre [i]);
	    writer.newLine ();
	}

	//Display to the user when backup is complete
	System.out.println ("Your backup has been created!");
	writer.close ();
    }


    //Seventh Method - Delete songs in the collection
    static void delete (String[] song, String[] artist, String[] genre, int[] counter, String[] name) throws IOException
    {
	String delete, response;
	boolean deleted;
	do
	{
	    BufferedWriter writer = new BufferedWriter (new FileWriter (name [0] + ".txt"));

	    System.out.println ("What is the name of the song you would like to delete");
	    delete = stdin.readLine ();
	    deleted = false;
	    //For loop to look for the song in the file
	    for (int i = 0 ; i < counter [0] ; i++)
	    {
		if (delete.equals (song [i]))
		{
		    for (int j = i ; j < counter [0] ; j++)
		    {
			song [j] = song [j + 1];
			artist [j] = artist [j + 1];
			genre [j] = genre [j + 1];
		    }
		    deleted = true;
		    counter [0]--;
		}
	    }

	    //Display to the user that the song has been successfully deleted
	    if (deleted == true)
	    {
		System.out.println ("Your song has successfully been deleted");
	    }

	    //If the song requested to delete has not been found in the file
	    else
	    {
		System.out.println ("Unfortunately, your song has not been found and could not be deleted!");
	    }

	    for (int i = 0 ; i < counter [0] ; i++)
	    {
		writer.write (song [i]);
		writer.newLine ();
		writer.write (artist [i]);
		writer.newLine ();
		writer.write (genre [i]);
		writer.newLine ();
	    }
	    writer.close ();

	    System.out.println ();
	    System.out.println ("Would you like to delete another song, y for Yes and anything else for no");
	    response = stdin.readLine ();
	}
	while (response.equals ("y") || response.equals ("Y"));
    }


    //Eight Method - To switch accounts
    static void changeAccount (String[] name, String[] song, String[] artist, String[] genre, int[] counter) throws IOException
    {
	String pass, userPassword, line = null;
	counter [0] = 0;

	System.out.println ();
	// Ask user what the username of the account they would like to switch to is
	System.out.println ("Which account would you like to switch to?");
	name [0] = stdin.readLine ();
	System.out.println ();

	BufferedReader reader = new BufferedReader (new FileReader (name [0] + ".txt"));
	pass = reader.readLine ();

	//Ask user for a password for that account
	System.out.println ("Please enter your password");
	userPassword = stdin.readLine ();

	if (pass.equals (userPassword))
	{
	    System.out.println ("You have succesfully switched accounts");
	    while ((line = reader.readLine ()) != null)
	    {
		song [counter [0]] = line;
		artist [counter [0]] = reader.readLine ();
		genre [counter [0]] = reader.readLine ();

		counter [0]++;
	    }
	}

	//If the username and password do not match, the user is directed back to the main menu
	else
	{
	    System.out.println ("The entered Username or Password is incorrect!");
	}
	reader.close ();
    }


    //Ninth Method - List of upcoming songs by their favourite artists they'd like to store
    static void futureSongs (String[] name, String[] artist, String[] song, String[] genre, int[] counter) throws IOException
    {
	String future;

	System.out.println ("Would you like a seperate list of future songs?");
	future = stdin.readLine ();

	//if user says yes, then proceed otherwise exit
	if (future.equals ("y") || future.equals ("Y"))
	{
	    System.out.println ("What would you like to name your file?");
	    name [0] = stdin.readLine ();
	    System.out.println ("Unless you want a blank file! Please go back to the main menu and use the next method to add songs");
	}

	else
	{
	    System.out.println ("You will be directed back to the main menu");
	}
    }


    //Tenth Method - Adding songs to the future list
    static void futureAdd (String[] name, String[] artist, String[] song, String[] genre, int[] counter) throws IOException
    {
	BufferedWriter writer = new BufferedWriter (new FileWriter (name [0] + " future.txt", true));
	String response;

	do
	{
	    System.out.println ();

	    System.out.println ("Which song would you like to enter into your future collection?");
	    song [counter [0]] = stdin.readLine ();
	    writer.write (song [counter [0]]);
	    writer.newLine ();

	    System.out.println ("Please enter the name of the artist");
	    artist [counter [0]] = stdin.readLine ();
	    writer.write (artist [counter [0]]);
	    writer.newLine ();

	    System.out.println ("Please enter the genre");
	    genre [counter [0]] = stdin.readLine ();
	    writer.write (genre [counter [0]]);
	    writer.newLine ();

	    System.out.println ("Awesome! Your song has been added to your new future list");

	    counter [0]++;

	    System.out.println ("");
	    System.out.println ("Do you wish to add any other songs (y for yes, any other key for no");
	    response = stdin.readLine ();
	}
	while (response.equals ("y") || response.equals ("Y"));

	writer.close ();
    }


    //Eleventh Method - Exiting the program
    static void exit (String[] name)
    {
	System.out.println ();
	System.out.println ("You have been logged out of " + name [0] + ".txt.You will be dearly missed!");
    }


    //main method
    public static void main (String str[]) throws IOException
    {
	DecimalFormat df = new DecimalFormat ("#");
	int userChoice;
	String runAgain;
	int[] counter = new int [1];
	int MAX = 100;
	String[] name = new String [1];
	String[] song = new String [MAX];
	String[] artist = new String [MAX];
	String[] genre = new String [MAX];

	//initialize everything
	login (name, song, artist, genre, counter);

	System.out.println ("This program will allow you to maintain your songs");

	do
	{
	    //display menu
	    System.out.println ("********************************************************");
	    System.out.println ("->   1. View your collection                                <-");
	    System.out.println ("->   2. Add to your collection                              <-");
	    System.out.println ("->   3. Search for music already in your collection         <-");
	    System.out.println ("->   4. Sort your collection                                <-");
	    System.out.println ("->   5. Create a backup for your collection                 <-");
	    System.out.println ("->   6. Delete a song from the collection                   <-");
	    System.out.println ("->   7. Change accounts                                     <-");
	    System.out.println ("->   8. Create a list for upcoming music                    <-");
	    System.out.println ("->   9. Add songs to your upcoming music                    <-");
	    System.out.println ("->   10. Exit                                               <-");
	    System.out.println ("********************************************************");
	    System.out.println ("Enter a number");

	    //loop to see if user enters proper number
	    do
	    {
		userChoice = Integer.parseInt (stdin.readLine ());

		if (userChoice < 1 || userChoice > 10)
		{
		    System.out.println ("Please enter a valid option");
		}
	    }
	    while (userChoice < 1 || userChoice > 10);

	    //switch statement for the cases
	    switch (userChoice)
	    {
		case 1:
		    view (song, artist, genre, counter);
		    break;
		case 2:
		    addToCollection (song, artist, genre, counter, name);
		    break;
		case 3:
		    search (song, artist, genre, counter);
		    break;
		case 4:
		    sort (song, artist, genre, counter, name);
		    break;
		case 5:
		    backup (song, artist, genre, counter, name);
		    break;
		case 6:
		    delete (song, artist, genre, counter, name);
		    break;
		case 7:
		    changeAccount (name, song, artist, genre, counter);
		    break;
		case 8:
		    futureSongs (name, song, artist, genre, counter);
		    break;
		case 9:
		    futureAdd (name, song, artist, genre, counter);
		    break;
		case 10:
		    exit (name);
		    break;
		    //the methods
	    }
	}
	while (userChoice != 10);
    }
}


