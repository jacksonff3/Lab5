import java.util.ArrayList;

public class SongPlayList {

    private SongNode root;
    private ArrayList<Song> PlayListData = new ArrayList<>();
    private ArrayList<Song> subSetList = new ArrayList<>();

    public void subSet(Song start, Song end) {

        int startingIndex = PlayListData.indexOf(start);            //Sets the starting index
        int endingIndex = PlayListData.indexOf(end);                //Sets the ending index

        for(int i = startingIndex + 1; i < endingIndex; i++) {      //startingIndex +1 because we're looking for whats between the starting and ending index,
                                                                    //Not the starting and ending index itself only what's between them
            subSetList.add(PlayListData.get(i));                    //Loops and adds all the index i's into the subSet

        }

    }

    private void append(SongNode current, Song song) {

        if (current != null) {                                      //Checks if the current node is empty

            if (song.getArtist().compareToIgnoreCase(current.getData().getArtist()) < 0) {  //Compares an artist with the current artist
                if (current.getLeft() == null) {                                            //If the artist being compared with the current artist returns -1
                    current.setLeft(new SongNode(song));                                    //and the left branch is empty, put that artist in the left branch
                    PlayListData.add(song);
                } else {
                    append(current.getLeft(), song);
                }
            } else {
                if (current.getRight() == null) {                                      //if the opposite of the above is true put the artist on the right branch
                    current.setRight(new SongNode(song));
                    PlayListData.add(song);
                } else {
                    append(current.getRight(), song);
                }
            }
        }else{
            root = new SongNode(song);                      //If both of the above conditions aren't satisfied, make a new root
            PlayListData.add(song);
        }
    }

    public void append1(Song song)
    {
        append(root, song);
    }


    private void printInorder(SongNode current)
    {
        if(current == null)
        {
            return;
        }

        printInorder(current.getLeft());

        System.out.println(current.getData().getSongTitle());

        printInorder(current.getRight());
    }



    public void print()
    {
        printInorder(root);
    }

    public SongNode getRoot()
    {
        return root;
    }

    public ArrayList<Song> getPlayListData()
    {
        return PlayListData;
    }

    public ArrayList<Song> getSubSetList()
    {
        return subSetList;
    }
}