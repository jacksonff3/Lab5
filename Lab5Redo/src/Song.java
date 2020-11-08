public class Song {
    
    private String rank;
    private String songTitle;
    private String artist;
    private int timesStreamed;
    private String URL;
    private double streamAverage;
    private int artistCount = 0;
    private int trackCount = 0;

    public Song(String rank, String songTitle, String artist, int timesStreamed, String URL) {
        
        this.artist = artist.replaceAll("\"", "").strip();
        this.rank = rank;                                                         //Replaces all Quotes in the csv file to make it more neat
        this.songTitle = songTitle.replaceAll("\"", "").strip();
        this.timesStreamed = timesStreamed;
        this.streamAverage = timesStreamed;
        this.URL = URL;
   
    }

    public void setSongTitle(String songTitle) {
       
        this.songTitle = songTitle;
    
    }

    public void setArtist(String artist) { 
       
        this.artist = artist;
    }

    public void setRank(String rank) {
        
        this.rank = rank;
    
    }

    public void setURL(String URL) {
        
        this.URL = URL;
    
    }

    public void setTimesStreamed(int timesStreamed) {
        
        this.timesStreamed += timesStreamed;           //Adds the streams of all the artists tracks
    
    }

    //public void setNumberOfFileAppearedIn(int count) {
        
        //this.numberOfFileAppearedIn += count;
    
   // }


    public void setTrackCount(int trackCount){
        this.trackCount = trackCount;
    }

    public void setStreamAverage() {
       
        streamAverage = (double) timesStreamed / artistCount; //We can find the artist average streams by the total amount
                                                              // of streams divided by the amount of time they appear on the csv files
    }

    public void setArtistCount(int artistCount) {
        
        this.artistCount += artistCount;                  //Counts tha amount of times the artist appear on the charts
    
    }

    public double getStreamAverage() {
        
        return streamAverage;                          // Returns the artist's stream average
    
    }

    public String getSongTitle() {
       
        return songTitle;
    
    }

    public String getArtist() {
        
        return artist;
    
    }

    public int getArtistCount() {
        
        return artistCount;
    
    }

    public String getRank() {
        
        return rank;
    
    }

    public String getURL() {
        
        return URL;
    
    }

    public int getTimesStreamed() {
       
        return timesStreamed;
   
    }

    public int getTrackCount() {
       
        return trackCount;
    
    }
}