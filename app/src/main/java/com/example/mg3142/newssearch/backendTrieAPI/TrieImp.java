package com.example.mg3142.newssearch.backendTrieAPI;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 * Implements trie interface
 * @author PaulaKayongo
 */
//@SuppressWarnings("all")
public class TrieImp implements Trie
{
    /********************************Instance Properties *************************************************/
    //root node variable
    private TrieNode root ;
    //An array list to hold the full word in the trie to be used when refreshing the URL
    private ArrayList<String> wordlist;
    //the amount of time taken to search a word
    private long time ;
    //word array resulting from an auto complete
    private String word;
    //String of auto complete
    private ArrayList<String> autocomplete;

    /*******************************Instance Methods ******************************************************/

    /**
     * Constructor
     */
    public TrieImp()
    {
        //Initializes the words array list
        wordlist=new ArrayList<String>();
        //String of autocomplete
        autocomplete=new ArrayList<String>();
        //initializes word to an empty string
        word="";
        //Creates a new Trie
        root=(TrieNodeImp) createTrie();
        trieCreator();
    }

    public void trieCreator() {
        wordlist.add("isis");
        insert("isis");
        TrieNode isis = search("isis");
        String[] isisNYTitle = {"Q. and A. on ISIS Hostages Held in Syria"};
        String[] isisNYUrl = {"http://www.nytimes.com/2014/11/01/world/middleeast/q-and-a-on-isis-hostages-held-in-syria.html"};
        String[] isisGTitle = {"How Isis got its anthem", "Behind the Headlines: Isis - who said what", "Rhetoric: Britain's weapon against Isis and Putin", "Egyptian jihadis pledge allegiance to Isis", "How can Isis afford its own currency?", "Kurdish women need arms to fight Isis | @guardianletters", "Uprising could trigger Isis undoing", "says study", "Isis looms over Gaza sideshow | @guardianletters", "Getting through to Isis could take years | @guardianletters", "Bahraini activist arrested over tweets about Isis"};
        String[] isisGUrl = {"http://www.theguardian.com/music/2014/nov/09/nasheed-how-isis-got-its-anthem", "http://www.theguardian.com/membership/2014/nov/27/behind-the-headlines-isis-who-said-what", "http://www.theguardian.com/politics/defence-and-security-blog/2014/nov/18/cameron-terror-isis-putin-ukraine", "http://www.theguardian.com/world/2014/nov/10/egyptian-jihadists-pledge-allegiance-isis", "http://www.theguardian.com/world/shortcuts/2014/nov/16/how-can-isis-afford-its-own-currency", "http://www.theguardian.com/world/2014/oct/30/empowered-kurdish-women-fighters-need-arms", "http://www.theguardian.com/world/2014/nov/01/uprising-trigger-isis-undoing-study", "http://www.theguardian.com/world/2014/aug/08/isis-looms-over-gaza-sideshow1", "http://www.theguardian.com/world/2014/oct/13/getting-through-to-isis-could-take-years", "http://www.theguardian.com/world/2014/oct/02/bahraini-activist-arrested-tweets"};
        ArrayList<String> isisNTitles =new ArrayList<String>(Arrays.asList(isisNYTitle));
        isis.setTimesTitles(isisNTitles);
        isis.setTimesURLs(new ArrayList<String>(Arrays.asList(isisNYUrl)));
        isis.setGuardTitles(new ArrayList<String>(Arrays.asList(isisGTitle)));
        isis.setGuardURLs(new ArrayList<String>(Arrays.asList(isisGUrl)));

        wordlist.add("ebola");
        insert("ebola");
        TrieNode ebola = search("ebola");
        String[] ebolaNYTitle = {"Alarmed by Ebola", "Public Isn't Calmed by Experts Say", "Using Ebola Care as a National Health Model ", "Better Staffing Seen as Crucial to Ebola Treatment in Africa", "Girl", "7", "Barred From a Connecticut School Over Ebola Concerns Goes Back to Class", "Liberians form Ebola task force", "Dallas nurse reunited with with Ebola-free dog", "Dallas Nurse Who Survived Ebola Reunited With Dog", "Condition of New York Doctor With Ebola Upgraded to 'Stable'", "Spanish Woman Cured of Ebola Moves to Normal Room"};
        String[] ebolaNYUrl = {"http://www.nytimes.com/2014/11/01/us/alarmed-by-ebola-public-isnt-calmed-by-experts-say-.html", "http://www.nytimes.com/2014/11/01/opinion/using-ebola-care-as-a-national-health-model.html", "http://www.nytimes.com/2014/11/01/us/better-staffing-seen-as-crucial-to-ebola-treatment-in-africa.html", "http://www.nytimes.com/2014/11/01/nyregion/connecticut-girl-returns-to-school-after-being-barred-amid-ebola-fears.html", "http://www.nytimes.com/video/multimedia/100000003210249/liberians-form-ebola-task-force.html", "http://www.nytimes.com/video/multimedia/100000003210488/dallas-nurse-reunited-with-with-ebola-free-dog.html", "http://www.nytimes.com/aponline/2014/11/01/us/ap-us-ebola-nurse-dogs-release.html", "http://www.nytimes.com/reuters/2014/11/01/us/01reuters-health-ebola-usa-patient.html", "http://www.nytimes.com/aponline/2014/11/01/world/europe/ap-eu-spain-ebola.html"};
        String[] ebolaGTitle = {"Ebola funding tracker – interactive", "How Nigeria defeated Ebola", "Ebola epidemic 2014: timeline", "Spain defends Ebola repatriations", "Ebola crisis - the Guardian briefing", "I survived Ebola - video", "Visualised: Ebola cases over time", "Ebola in the US: timeline", "Ebola cases surge in Sierra Leone", "Ebola vaccine trial results promising", "says manufacturer"};
        String[] ebolaGUrl = {"http://www.theguardian.com/global-development/datablog/ng-interactive/2014/oct/28/-sp-ebola-funding", "http://www.theguardian.com/global-development-professionals-network/2014/oct/31/ebola-nigeria-state-public-sector-calestous-juma", "http://www.theguardian.com/world/2014/oct/15/ebola-epidemic-2014-timeline", "http://www.theguardian.com/world/2014/oct/13/spain-ebola-repatriations-nurse", "http://www.theguardian.com/world/2014/sep/25/-sp-ebola-crisis-briefing", "http://www.theguardian.com/society/video/2014/aug/22/i-survived-ebola-sierra-leone-video", "http://www.theguardian.com/world/ng-interactive/2014/oct/27/visualised-ebola-cases-over-time", "http://www.theguardian.com/world/2014/oct/17/ebola-in-the-us-timeline", "http://www.theguardian.com/global-development/2014/dec/01/ebola-cases-surge-in-sierra-leone", "http://www.theguardian.com/world/2014/nov/26/ebola-vaccine-trial-results-promising-glaxosmithkline"};
        ebola.setTimesTitles(new ArrayList<String>(Arrays.asList(ebolaNYTitle)));
        ebola.setTimesURLs(new ArrayList<String>(Arrays.asList(ebolaNYUrl)));
        ebola.setGuardTitles(new ArrayList<String>(Arrays.asList(ebolaGTitle)));
        ebola.setGuardURLs(new ArrayList<String>(Arrays.asList(ebolaGUrl)));

        wordlist.add("syria");
        insert("syria");
        TrieNode syria = search("syria");
        String[] syriaNYTitle = {"Q. and A. on ISIS Hostages Held in Syria", "Syrian�s Photos Spur Outrage", "but Not Action", "Iraqi Peshmerga Fighters Prepare for Syria Battle", "U.S. Military Launches 10 Air Strikes in Syria", "Iraq", "Al Qaeda Group Seizes Bastion of Western-Backed Rebels in Syria's Idlib Region"};
        String[] syriaNYUrl = {"http://www.nytimes.com/2014/11/01/world/middleeast/q-and-a-on-isis-hostages-held-in-syria.html", "http://www.nytimes.com/2014/11/01/world/middleeast/syrian-photographers-record-of-deaths-generates-outrage-but-little-action.html", "http://www.nytimes.com/aponline/2014/11/01/world/middleeast/ap-ml-syria.html", "http://www.nytimes.com/reuters/2014/11/01/world/middleeast/01reuters-mideast-crisis-usa-airstrikes.html", "http://www.nytimes.com/reuters/2014/11/01/world/middleeast/01reuters-syria-crisis-nusra.html"};
        String[] syriaGTitle = {"Coincidences of interests in Syria | @guardianletters", "Syria's civil war has forced 3m refugees to flee the country – why is the US accepting so few?", "Derry man arrested over Syria activities", "Third Portsmouth jihadist reported killed in Syria", "Options in Syria | @guardianletters", "Eyewitness: Homs city", "Syria", "Syria: bombs and ballots | Editorial", "UN to cut food aid to Syria", "CBS reporter risks her life to report on western jihadists in Syria", "Justice in the balance over Syria jihad case | Letters: Dr Richard Carter", "Michael Leeder", "Jeremy Beecham"};
        String[] syriaGUrl = {"http://www.theguardian.com/world/2014/sep/22/coincidences-of-interests-in-syria", "http://www.theguardian.com/world/2014/oct/06/syria-refugees-syria-civil-war-guide", "http://www.theguardian.com/uk-news/2014/nov/06/derry-man-arrested-syria-activities", "http://www.theguardian.com/uk-news/2014/oct/21/third-portsmouth-jihadist-killed-syria-manunur-roshid-kobani", "http://www.theguardian.com/theguardian/2014/may/15/syria-assad-fgm-kollwitz-nhs", "http://www.theguardian.com/world/picture/2014/may/11/eyewitness-homs-syria", "http://www.theguardian.com/commentisfree/2014/apr/20/syria-bombs-and-ballots", "http://www.theguardian.com/global-development/2014/sep/18/world-food-programme-cut-aid-syria", "http://www.theguardian.com/media/greenslade/2014/oct/08/cbs-syria", "http://www.theguardian.com/politics/2014/dec/02/justice-in-the-balance-over-syria-jihad-case"};
        syria.setTimesTitles(new ArrayList<String>(Arrays.asList(syriaNYTitle)));
        syria.setTimesURLs(new ArrayList<String>(Arrays.asList(syriaNYUrl)));
        syria.setGuardTitles(new ArrayList<String>(Arrays.asList(syriaGTitle)));
        syria.setGuardURLs(new ArrayList<String>(Arrays.asList(syriaGUrl)));

        wordlist.add("immigration");
        insert("immigration");
        TrieNode immigration = search("immigration");
        String[] immigrationNYTitle = {""};
        String[] immigrationNYUrl = {""};
        String[] immigrationGTitle = {"How to teach … immigration", "David Cameron's immigration speech – as it happened", "Conservatives walk immigration tightrope at Rochester byelection", "Dreamer leaders signal opposition to Rubio on immigration reform", "Statistics alone won’t win the immigration debate | Owen Jones", "Immigration", "EU freedoms", "neoliberalism and the left | @guardianletters", "Immigration: reality check | Editorial", "Can Swedish politicians avert a meltdown on immigration? | Andrew Brown", "Owen Paterson: immigration issue cannot wait for EU renegotiation", "Another Norman Tebbit immigration test? This time it’s war | Sonia Sodha"};
        String[] immigrationGUrl = {"http://www.theguardian.com/teacher-network/teacher-blog/2014/nov/24/how-to-teach-immigration", "http://www.theguardian.com/politics/blog/live/2014/nov/28/david-camerons-immigration-speech-politics-live-blog", "http://www.theguardian.com/politics/2014/nov/19/conservatives-walk-immigration-tightrope-analysis", "http://www.theguardian.com/world/2013/feb/12/dreamer-immigration-marco-rubio-opposition", "http://www.theguardian.com/commentisfree/2014/nov/05/statistics-immigration-debate-european-migrants-uk-20bn", "http://www.theguardian.com/uk-news/2014/oct/26/immigration-european-union-freedoms-neoliberalism-left", "http://www.theguardian.com/commentisfree/2014/may/14/immigration-reality-check-ukip-farage-editorial", "http://www.theguardian.com/commentisfree/2014/dec/03/swedish-politicians-avert-meltdown-immigration", "http://www.theguardian.com/uk-news/2014/nov/30/owen-paterson-immigration-issue-cannot-wait-eu-renegotiation", "http://www.theguardian.com/commentisfree/2014/nov/30/another-norman-tebbit-immigration-test-this-time-war"};
        immigration.setTimesTitles(new ArrayList<String>(Arrays.asList(immigrationNYTitle)));
        immigration.setTimesURLs(new ArrayList<String>(Arrays.asList(immigrationNYUrl)));
        immigration.setGuardTitles(new ArrayList<String>(Arrays.asList(immigrationGTitle)));
        immigration.setGuardURLs(new ArrayList<String>(Arrays.asList(immigrationGUrl)));

        wordlist.add("Landrieu");
        insert("Landrieu");
        TrieNode landrieu = search("Landrieu");
        String[] landrieuNYTitle = {""};
        String[] landrieuNYUrl = {""};
        String[] landrieuGTitle = {"Mary Landrieu set for defeat in Louisiana runoff as voters head to the polls", "Louisiana senator Mary Landrieu faces bumpy ride on the Bayou", "Louisiana senator Mary Landrieu calls on government to lift EPA ban on BP"};
        String[] landrieuGUrl = {"http://www.theguardian.com/us-news/2014/dec/06/mary-landrieu-louisiana-voters-polls", "http://www.theguardian.com/world/2014/jun/23/louisana-senator-mary-landrieu-midterms", "http://www.theguardian.com/environment/2013/mar/06/mary-landrieu-bp-epa-ban"};
        landrieu.setTimesTitles(new ArrayList<String>(Arrays.asList(landrieuNYTitle)));
        landrieu.setTimesURLs(new ArrayList<String>(Arrays.asList(landrieuNYUrl)));
        landrieu.setGuardTitles(new ArrayList<String>(Arrays.asList(landrieuGTitle)));
        landrieu.setGuardURLs(new ArrayList<String>(Arrays.asList(landrieuGUrl)));

    }

    public void setUpList(String filePath)
    {
        // Location of file to read
        File file = new File(filePath);
        //Initially sets scanner to null
        Scanner scanner=null;
        try
        {
            //scans the the file that that has been passed
            scanner = new Scanner(file);
            //sets the delimiter of the scanner to an enter
            scanner.useDelimiter(",");
            //checks that the scanner has a next line
            while(scanner.hasNext())
            {
                //obtain the line from the scanner
                String word = scanner.next();
                //adds the line to the list
                wordlist.add(word);
            }
            //closes the scanner once it is done reading
            scanner.close();

        }
        //in the case where the file is not found
        catch (FileNotFoundException e)
        {
            //prints out the error to the command line
            e.printStackTrace();
        }


    }

    /** Creates an empty tree with one node the root that
     * has no value therefore it returns just a singular trie node
     */
    @Override
    public TrieNode createTrie()
    {
        //returns the root node
        return (new TrieNodeImp('\0'));
    }


    /**
     * Inserts the word into the tree
     * The difference between this an insertWord is that this method is static
     * so it can be used for testing in the main method
     * @param word
     *
     */
    @Override
    public void insert(String word)
    {
        if(word.contains(" "))
        {
            word=word.replace(' ', '_');
        }
        //makes the word lower case
        word=word.toLowerCase();
        //checks if the word is already in the trie then does not insert it
        if (find(word) == true)
            //breaks
            return;
        //else sets the current node to the root
        TrieNodeImp current = (TrieNodeImp) root;
        //converts each character in the word to a character array then loops through the entire word
        for (char ch : word.toCharArray() )
        {
            //sets the child of the node to the next word i.e in the word cow
            //c's child would be o ,o's child would be w and w's child would be null
            TrieNode child = current.subNode(ch);
            //In the case where  the child is not null
            if (child != null)
                //sets the current to the child
                current = (TrieNodeImp) child;
                //In the case where we have iterated through the entire word and set the children
            else
            {
                //ads the first word to the child list
                //Consider the case where the only node present is the root thus root=current
                //we are inserting the word cow
                //This would set the roots child list to c-o-w in that ordered
                //as inferred from the working of the for loop
                current.childList.add(new TrieNodeImp(ch));
                //Consider the case where only C has been inserted this would set the current to w
                //and the loop would iterate till current is null
                //sets the current to the next the
                current = current.subNode(ch);
            }
            //sets the current count to the number of characters in the letter upon completion of for loop
            current.count++;
        }
        //sets the current is the end of the word
        //based on the assumption that user will enter full words
        current.setIsEnd(true);
        //checks if the word inserted is a full word then assigns
        //associated URL and Titles array list to that node after finding the word in the API
        if (current.isEnd()==true )
        {

            if(word.contains("_"))
            {
                word=word.replace('_',' ');
            }
        }

    }



    /**
     * Reads from the output
     */
    public void readFromOutput()
    {
        //last node from iteration
        TrieNode last=null;
        //stage of iteration
        int iteration=0;
        // Location of file to read
        File file = new File("../backendTrieAPI/Output.txt");
        //Initially sets scanner to null
        Scanner scanner=null;
        try
        {
            //scans the the file that that has been passed
            scanner = new Scanner(file);
            //sets the delimiter of the scanner to an enter
            scanner.useDelimiter(";");
            //checks that the scanner has a next line
            while(scanner.hasNext())
            {
                if (iteration%5==0)
                {
                    //obtain the line from the scanner
                    String word = scanner.next();
                    //adds the line to the list
                    wordlist.add(word);
                    //inserts the word to the tire
                    insert(word);
                    //gets the last node associated with the word
                    last= search(word);

                }

                else if (iteration%5==1  && scanner.hasNext())
                {
                    //holds value of scanner.next line
                    String s=scanner.next();
                    //gets the NY times aray list
                    ArrayList<String> urllist = new ArrayList<String>(Arrays.asList(s.substring(1,s.length()-1).split(",")));
                    //sets the las nodes array list to the list that was passed
                    last.setTimesURLs(urllist);
                }

                else if (iteration%5==2 && scanner.hasNext())
                {
                    //holds value of scanner.next line
                    String s2=scanner.next();
                    //gets the nY times title array list
                    ArrayList<String> titlelist = new ArrayList<String>(Arrays.asList(s2.substring(1,s2.length()-1).split(",")));
                    //sets the times titles to the array list
                    last.setTimesTitles(titlelist);
                }
                else if (iteration%5==3 && scanner.hasNext())
                {
                    //holds value of scanner.next line
                    String s3=scanner.next();
                    ////gets guardian array list
                    ArrayList<String> urllist = new ArrayList<String>(Arrays.asList(s3.substring(1,s3.length()-1).split(",")));
                    //sets the nodes guard title properties to the aray list
                    last.setGuardURLs(urllist);
                }
                else if (iteration%5==4 && scanner.hasNext())
                {
                    //holds value of scanner.next line
                    String s4=scanner.next();
                    //gets guards title array list
                    ArrayList<String> titlelist = new ArrayList<String>(Arrays.asList(s4.substring(1,s4.length()-1).split(",")));
                    //sets the nodes guard title property to the array list
                    last.setTimesTitles(titlelist);
                }
                //increases the iteration
                iteration++;
            }
            //closes the scanner once it is done reading
            scanner.close();

        }
        //in the case where the file is not found
        catch (FileNotFoundException e)
        {
            //prints out the error to the command line
            e.printStackTrace();
        }

    }


    /**
     * Returns true when the word is in the trie and false when it isn't
     * Finds a word/phrase in the Trie data structure given the root node
     */
    @Override
    public  boolean find(String word)
    {
        ///checks if the word contains a space
        if(word.contains(" "))
        {
            //replaces the space if that is the case
            word=word.replace(' ','_');
        }
        //sets the current node to the root
        TrieNode current = root;
        //makes the word lower case
        word=word.toLowerCase();
        //loops through the characters in the word that we have passed
        for (char ch : word.toCharArray() )
        {
            //This is the case where the passed character is not a sub node /child of the current
            if (current.subNode(ch) == null)
            {
                //This means the word is not in the tree
                return false;
            }
            else
                //sets the current to the child of the former current
                current = current.subNode(ch);
        }
        //If the current is a end
        if (current.isEnd() == true)
            //then the word is in the tree
            return true;
        //else the word is not in the tree
        return false;
    }

    /**
     * Returns the node that contains the URL arrayList
     * Finds a word/phrase in the Trie data structure given the root node
     */
    public TrieNode search( String word)
    {
        //time the search starts running
        long start = System.nanoTime();
        //checks if the word contains a space
        if(word.contains(" "))
        {
            //replaces the space
            word=word.replace(' ', '_');
        }
        //sets the current node to the root
        TrieNode current = root;
        //makes the word lower case
        word=word.toLowerCase();
        //loops through the characters in the word that we have passed
        for (char ch : word.toCharArray() )
        {
            //This is the case where the passed character is not a sub node /child of the current
            if (current.subNode(ch) == null)
                //This means the word is not in the tree
                return null;
            else
                //sets the current to the child of the former current
                current = current.subNode(ch);
        }
        //If the current is a end
        if (current.isEnd() == true)
        {
            //time the search stops running
            long end= System.nanoTime();
            //toal time taken to run search
            long time=((end-start)/1000);
            //Prints out the time to search
            System.out.println("Time to search in micro seconds"+ time);
            //then the word is in the tree
            return current;
        }
        System.out.println("got here!");
        //else the word is not in the tree
        return null;

    }


    /**
     * Auto compete method for the trie
     */
    public ArrayList<String>  autoComplete(char ch)
    {
        //returns result from depth first search
        return DFS(root.subNode(ch));
    }


    /**
     * Depth first search method for the trie
     * @param node
     */
    public ArrayList<String> DFS(TrieNode node)
    {

        //gets the letter at the node that was passed
        word=word+Character.toString(node.getcontent());
        //checks whether the node is an end
        if(node.isEnd())
        {
            //adds the word to the auto complete array list
            autocomplete.add(word);
        }
        //loops through the children of the node
        for (TrieNode tn: node.getLinks())
        {
            //calls Depth first search on the children
            DFS(tn);
            //shortens the length of the words to allow for the recursion to back track
            word = word.substring( 0, word.length()-1);
        }
        //returns the auto completed array
        return autocomplete;

    }

    /**
     * Prints the trie by doing a DFS search on the Tree
     */
    public  void printTree()
    {
        //calls DFS on the root
        DFS(root);
        //Prints the autocomplete
        for(int i=0;i<autocomplete.size();i++)
        {
            //prints all the values in the array
            System.out.println(autocomplete.get(i));
        }

    }


    /**
     * Getter method for the root
     */
    public TrieNode getRoot()
    {
        return root;
    }

    /**
     * Getter method for the trie
     */
    public Trie getTrie()
    {
        return this;
    }

    /**
     * Gets the time it takes to search a word
     */
    public long getTime()
    {
        return time;
    }


}