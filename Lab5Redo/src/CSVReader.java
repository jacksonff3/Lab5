import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
public class CSVReader {

    private ArrayList<ArtistTracks> artistList = new ArrayList<>();
    private ArrayList<Song> artistSongs = new ArrayList<>();
    private ArrayList<Song> unSortedSongList = new ArrayList<>();
    private ArrayList<ArtistTracks> unSortedArtistList = new ArrayList<>();
    private ArrayList<String> csvList = new ArrayList<>();
    private Scanner input = new Scanner(System.in);



    public void scanCSV(String[] csvFiles) {

        try {

            Queue queue = new Queue();
            for(int i = 0; i < csvFiles.length; i++) {

                queue.append(csvFiles[i]);   //Add the files into a queue to be read, first file in is the first one that's read

            }
            int counter = 0;                     //Counter counts the amount of files read
            int size = queue.getSize();

            while(counter < size) {    //If the counter is lower than queue size it means there's more csv files in queue

                Scanner csvScanner = new Scanner(new File(queue.getHead()));
                csvScanner.nextLine();
                csvScanner.nextLine();

                while (csvScanner.hasNextLine()) {

                    String line = csvScanner.nextLine();
                    csvList.add(line);                   //This combines ALL the csv lists into 1 list

                }

                queue.remove();          //Once the file is finished being read, it removes that file from the queue
                counter++;       //Counts the file that just got read
            }

            handleClass();

        }catch(Exception e) {

            System.out.println(e.getMessage());

        }
    }

    public void handleClass() {

        int leftPointer = 0;
        int rightPointer = 200;
        int fileCount = 1;
        int pointerIncreaser = 0;
        int size = csvList.size()/200;
        int i=0;
        while(i < size) {

            for(int j = leftPointer + pointerIncreaser; j < rightPointer + pointerIncreaser; j++) {

                int artistCount = 0;
                String[] information = csvList.get(j).split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");     //Splits the csvFiles into columns and removes all punctuations
                ArtistTracks artist = new ArtistTracks(information[2]);                                        //[2] is the line filled with artist names
                Song song = new Song(information[0], information[1], information[2], Integer.parseInt(information[3]), information[4]); //Making song objects using loop
                unSortedSongList.add(song); //UnsortedSongList is a SongList full of song objects that isn't sorted in alphabetical order
                unSortedArtistList.add(artist); //Same as SongList, but for Artist.



                boolean flag = false;
                int artistListIndex = 0;
                for (int x = 0; x < artistList.size(); x++) {
                    if (artistList.get(x).getArtistName().equalsIgnoreCase(artist.getArtistName())) {
                                                                                                        //Counts artist duplicates and lets us know if there is
                        flag = true;
                        artistListIndex = x;
                        ++artistCount;

                    }
                }

                boolean flag1 = false;
                int songListIndex = 0;
                for (int l = 0; l < artistSongs.size(); l++) {
                    if (artistSongs.get(l).getSongTitle().equalsIgnoreCase(song.getSongTitle())) {    //Looks for song duplicates throughout the lists

                        flag1 = true;
                        songListIndex = l;

                    }
                }
                if (artistSongs.isEmpty()) {
                    artistSongs.add(song);
                }
                else if (!artistSongs.isEmpty()) {
                    song.setTrackCount(fileCount);                                             //Keeps tracks of how many charts the songs appear in
                    artistSongs.add(song);
                }
                else if (!artistSongs.isEmpty() && flag1 == true) {
                    artistSongs.get(songListIndex).setTrackCount(fileCount);
                    artistSongs.get(songListIndex).setTimesStreamed(song.getTimesStreamed());
                }

                if (artistList.isEmpty()) {

                    artist.setArtistCount(++artistCount);

                    artist.addSong(song);
                    artistList.add(artist);
                }
                else if (!artistList.isEmpty() && flag == false) {

                    artist.setArtistCount(++artistCount);                   //Keeps tracks of the amount of charts the artists appear in
                    artist.addSong(song);
                    artistList.add(artist);
                }
                else if (!artistList.isEmpty() && flag == true) {

                    artistList.get(artistListIndex).setArtistCount(artistCount);
                    artistList.get(artistListIndex).addSong(song);
                }
            }


            pointerIncreaser+=200;
            i++;
        }

        for(int z = 0; z < artistList.size(); z++)
        {
            artistList.get(z).setArtistAverage();
        }
    }

    public void Menu() {
        Scanner keyboard = new Scanner(System.in);
        String strInput;
        int intInput;
        System.out.println("1. Search 2. Create Playlist 3. Quit");
        intInput = keyboard.nextInt();
        if (intInput == 1){

            System.out.println("What would you like to search for? 1. Artist 2. Track");

            if(intInput == 1){

                System.out.println("What's the artist's name?");
                strInput = keyboard.next();

                for(int u = 0; u < artistList.size(); u++) {

                    if(artistList.get(u).getArtistName().equalsIgnoreCase(strInput)) {

                        artistList.get(u).printList();

                    }
                }
            }
            else if( intInput == 2){
                System.out.println("What is the song name?");
                strInput = keyboard.next();

                for(int u = 0; u < artistSongs.size(); u++) {

                    if(artistSongs.get(u).getSongTitle().equalsIgnoreCase(strInput)) {

                        System.out.println(artistSongs.get(u).getArtist());

                    }
                }
            }

        }

        else if (intInput == 2){

                Queue list = new Queue();
                int u = 0;
                while(u < 5) {
                    System.out.println("What song would you like to add?");
                    strInput = keyboard.next();
                    for(int j = 0; j < artistSongs.size(); j++) {
                        if(artistSongs.get(j).getSongTitle().equalsIgnoreCase(strInput)) {
                            list.append2(artistSongs.get(j));
                        }
                    }

                    u++;
                }
        }
        else if(intInput == 3){
            System.exit(0);
        }
    }


    public ArrayList<Song> getArtistSongs()
    {
        return artistSongs;
    }

    public ArrayList<ArtistTracks> getArtistList()
    {
        return artistList;
    }

}
