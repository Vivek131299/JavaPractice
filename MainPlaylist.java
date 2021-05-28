import java.util.*;

public class MainPlaylist {

    private static List<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album album  = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Holy Man", 4.2);
        album.addSong("Hold on", 3.6);
        album.addSong("High ball shooter", 4.1);
        album.addSong("The gypsy", 6.22);
        album.addSong("Soldier of fortune", 3.55);

        albums.add(album);

        album  = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("Lets go", 3.4);
        album.addSong("Inject the venom", 6.22);
        album.addSong("Snowballed", 4.36);
        album.addSong("Evil walks", 5.01);
        album.addSong("Breaking the rules", 4.18);

        albums.add(album);

        List<Song> playList = new ArrayList<Song>(); // First there we had LinkedList playList, and now we have done List and ArrayList,
                                                     // but still code works fine because Lists, ArrayLists, LinkedLists and Vector internally
                                                      // implements same interfaces. (this is edit from Interfaces lecture).
        albums.get(0).addToPlaylist("Holy Man", playList); // Here, we are adding the song named 'Holy Man',
                                                                // from the 1st album (albums.get(0)) from albums ArrayList to the playList.
        albums.get(0).addToPlaylist("The gypsy", playList);
        albums.get(0).addToPlaylist("Speed King", playList); // Now here, this song 'Speed King' does not exist in our
                                                                  // first album(albums.get(0), and we are trying to add that song
                                                                  // into playList, So this should give us an error.
        albums.get(0).addToPlaylist(6, playList); // Here, we are adding song into playList using its trackNumber
                                                              // which is 6 for the song 'Soldier of fortune' in this case.

        // Adding songs from second album(of albums ArrayList) to the playList.
        albums.get(1).addToPlaylist(1, playList);
        albums.get(1).addToPlaylist(3, playList);
        albums.get(1).addToPlaylist(5, playList);
        albums.get(1).addToPlaylist(15, playList); // This should give us an error because song having trackNumber
                                                              // does not exists in second album(albums.get(1)) in albums ArrayList.

        play(playList);
    }

    private static void play(List<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
        } else {
            System.out.println("Now playing: " + listIterator.next().toString());
                //Above, we have used .toString() because, listIterator.next() will return the object of type Song,
                // which we can't print in 'System.out.println()' (beacuse it supports String.
                // So we have overridden the toString() method in Song class to print the title and duration of the
                // song in String format.
                // So, we are not actually accessing the Java inbuilt method toString() here, but we are accessing the
                // overridden toString() method in Song class.
            printMenu(); // Printing menu for the first time after playing first song(above).
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;

                case 1:
                    if (!forward) { // This if block is used to check if we are moving in forward direction.
                                    // If not, we set forward=true showing that now we are moving in forward direction.
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing: " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;

                case 2:
                    if (forward) { // This if block is used to check if we are moving in backward direction.
                                    // If not, we set forward=false showing that now we are moving in backward direction.
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing: " + listIterator.previous().toString());
                    } else {
                        System.out.println("We have reached the start of the playlist");
                        forward = true;
                    }
                    break;

                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying: " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the playlist");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying: " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the playlist");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) { // This is to move forward after deleting current song to avoid error which will occur if we try to delete this song again.
                            System.out.println("Now playing: " + listIterator.next());
                        } else if (listIterator.hasPrevious()) { // This is to move backward after deleting current song to avoid error which will occur if we try to delete this song again.
                            System.out.println("Now playing: " + listIterator.previous());
                        }
                    }
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\nPress ");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions\n" +
                "6 - delete current song from playlist.");
    }

    private static void printList(List<Song> playList) {
        Iterator<Song> iterator = playList.iterator(); // We are using regular Iterator here instead of ListIterator because,
                                                           // we are not going backwards and forwards here(we just have to print playList).
        System.out.println("===============================================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next()); // We can also put here .toString() at the end like above but that's optional.
        }
        System.out.println("===============================================");
    }

}
