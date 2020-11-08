import java.util.ArrayList;
public class ArtistTracks {

    private String artistName;
    private int totalStream;
    private ArrayList<Song> artistTracks;
    private double artistAverage;
    private int artistCount = 0;
    //private int numberOfFileAppearedIn = 0;

    public ArtistTracks(String artistName) {

        this.artistName = artistName.replaceAll("\"", "").strip(); //Removes all quotes from name makes it easier to read
        artistTracks = new ArrayList<>();

    }

    public void addSong(Song song) {                                                     //This method adds to the list of songs the artist has
        boolean flag = false;
        int index = 0;
        for(int i = 0; i < artistTracks.size(); i++) {

            if(song.getSongTitle().equalsIgnoreCase(artistTracks.get(i).getSongTitle())) {
                flag = true;
                index = i;

            }
        }

        if(!artistTracks.isEmpty() && flag == false) {

            artistTracks.add(song);

        }
        else if(!artistTracks.isEmpty() && flag == true) {

            return;

        }else {

            artistTracks.add(song);

        }
    }

    public double getArtistAverage() {

        return artistAverage;

    }

    public void setArtistCount(int count) {

        this.artistCount += count;

    }

    public void setArtistAverage() {

        this.artistAverage = (double) totalStream / artistCount;       //Finds the artist average stream throughout all the charts

    }

  //  public void setNumberOfFileAppearedIn() {

       // this.numberOfFileAppearedIn++;

  //  }


    public int getArtistCount() {

        return artistCount;

    }

    public void addStreamNumber(int num) {

        totalStream += num;

    }

    public int getTotalStream() {

        return totalStream;

    }

   // public int getNumberOfFileAppearedIn() {

       // return numberOfFileAppearedIn;

   // }

    public String getArtistName() {

        return artistName;

    }

    public ArrayList<Song> getSongsList() {

        return artistTracks;

    }

    public void printList() {
        System.out.println(artistName + " has " + artistTracks.size() + " songs: ");
        for(int i = 0; i < artistTracks.size(); i++) {                               //prints out the artists name, number of songs on chart, and the times streamed
                                                                                 //May print out duplicate songs if they're on more than one chart(likely)
            System.out.println(i+1 + ". " + artistTracks.get(i).getSongTitle() + " " + artistTracks.get(i).getTimesStreamed());

        }
    }


}