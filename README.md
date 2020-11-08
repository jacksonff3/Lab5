The problem we were given in this lab was to make a playlist for a dj sorting the songs by the artists name in alphabetical order using binary tree

I didn't successfully do it, but what I had in mind was

1) We would start by creating the song Object which contains all the information in the csv file such has song name, artist name, and time streamed

2) We read all the csv files and combined them into one LARGE CSV file with artist and song name duplicates

3) While we read all of this we need to keep track of the amount of times the artist appears in the csv files and at the same time add up their times streamed that way we can get their average played
by doing total times streamed / times the artist showed up.

4) Once we've gotten all the general information, artist name , song name, and streamed name we start to put them in the nodes of a binary tree. Since the dj wants them to be sorted by the artists name
alphabetically, we need a balanced binary tree. The names that appear first in the alphabet compared to the root goes to the left branch, while those that appear after the root or base, goes to the right branch

5) While doing this assignment I also tried using ArrayList so that the rank, artist name , song name, and times streamed would all be parallel.

6) Finally the dj also wanted a sublist, I think you would approach this the same way you approach the mainlist, but you just change the starting and ending point of the binary tree.



