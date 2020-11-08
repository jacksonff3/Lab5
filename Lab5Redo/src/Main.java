import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws Exception{


        Scanner keyboard = new Scanner(System.in);
        String[] fileList = {"regional-global-daily-2020-11-01, regional-global-daily-2020-11-02, regional-global-daily-2020-11-03, regional-global-daily-2020-11-03," +
                "regional-global-daily-2020-11-04, regional-global-daily-2020-11-05,regional-global-daily-2020-11-06, regional-global-daily-2020-11-07"};

        CSVReader reader = new CSVReader();

        reader.scanCSV(fileList);

        ArrayList<Song> song = reader.getArtistSongs();

        ArrayList<ArtistTracks> artistTrack = reader.getArtistList();

        quicksort(song, 0, song.size() - 1);


        SongPlayList tree = new SongPlayList();

        for(int i = 0; i < song.size(); i++) {

            tree.append1(song.get(i));

        }


        tree.subSet(song.get(0), song.get(song.size() - 1));

        ArrayList<Song> playListData = tree.getPlayListData();
        ArrayList<Song> subSetList = tree.getSubSetList();



        File file = new File("Artists-WeekOf11/1-7/2020.txt");
        file.createNewFile();
        FileWriter writeFile = new FileWriter(file);
        BufferedWriter writer = new BufferedWriter(writeFile);
        writer.write("List Of songs in week 1 of November:\n");

        for(int i = 0; i < playListData.size(); i++)
        {
            writer.write(i+1 + ". " + playListData.get(i).getSongTitle()
                    + " Total Stream: " + playListData.get(i).getTimesStreamed()
                    + " Average stream: " + playListData.get(i).getStreamAverage()
                    +"\n");
        }

        writer.write("\n");
        writer.write("Subset Report:\n");

        for(int j = 0; j < subSetList.size(); j++)
        {
            writer.write(j + 1 + ". " + subSetList.get(j).getSongTitle() + "\n");
        }

        writer.write("\n");
        writer.write("Artist Report:\n");

        for(int k = 0; k < artistTrack.size(); k++)
        {
            writer.write((k + 1 + ". " + artistTrack.get(k).getArtistName()
                    + " Total Appearance : " + artistTrack.get(k).getArtistCount()
                    + " Average Appearance: " + artistTrack.get(k).getArtistAverage() + "\n"));
        }

        writer.close();

    }

    public static void quicksort(ArrayList<Song> song, int low, int high) {
        int i = low, j = high;

        String pivot = song.get(low + (high - low) / 2).getSongTitle();

        while (i <= j)
        {
            while (song.get(i).getSongTitle().compareToIgnoreCase(pivot) < 0)
            {
                i++;
            }

            while (song.get(j).getSongTitle().compareToIgnoreCase(pivot) > 0)
            {
                j--;
            }

            if (i <= j)
            {
                swap(song, i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quicksort(song, low, j);
        }

        if (i < high) {
            quicksort(song, i, high);
        }


    }

    public static void swap(ArrayList<Song> song, int i, int j)
    {
        Song temp = song.get(i);
        song.set(i, song.get(j));
        song.set(j, temp);
    }
}
