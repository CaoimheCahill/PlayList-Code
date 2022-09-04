/**
 * Assignment 2022 Part2 (PlayListDriver Class)
 *
 * Student Number: 21331308
 * Name: Caoimhe Cahill
 *
 * 21st March 2022
 */


public class PlayListDriver {
        public static void main(String[] args) {

            // Create playlist
            PlayList album = new PlayList();
            PlayList favourites = new PlayList();

            // Check name
            System.out.println("Playlist with the default name " + "'"+ album.getName() + "'");

            // Create new playlist with name
            album = new PlayList("On Repeat");
            System.out.println("Playlist with the specified name of " + "'" + album.getName() + "'");

            // Change playlist name
            album.setName("Throwbacks");
            System.out.println("I've now changed the playlist name to " + "'" + album.getName() + "'");

            // Adding songs to playlist without year and time duration
            album.add("Payphone","Maroon 5, Wiz Khalifa");
            album.add("All Too Well","Taylor Swift");
            album.add("Boyfriend","Justin Bieber");
            album.add("Hips Don't Lie","Shakira");
            album.add("Timber","PitBull");
            album.add("Whatcha Say","Maroon 5, Jason Derulo");
            album.add("Poker Face","Lady Gaga");
            album.add("Dynamite","Taio Cruz");
            album.add("On The Floor","Jennifer Lopez");

            // Show what is in playlist
            System.out.println("\nPlaylist:");
            album.showList();

            // Adding songs to another playlist with year and time duration
            favourites.add("Payphone","Maroon 5, Wiz Khalifa",2002, (3 * 60) + 14);
            favourites.add("All Too Well","Taylor Swift",2021, (4 * 60) + 34);
            favourites.add("Boyfriend","Justin Bieber", 2014, (3 * 60) + 24);
            favourites.add("Hips Don't Lie","Shakira",2005, (4 * 60) + 11);
            favourites.add("Timber","PitBull",2010, (3 * 60) + 54);
            favourites.add("Whatcha Say","Jason Derulo",2015, (3 * 60) + 16);
            favourites.add("Poker Face","Lady Gaga",2004, (3 * 60) + 13);
            favourites.add("Dynamite","Taio Cruz",2002, (3 * 60) + 26);
            favourites.add("On The Floor","Jennifer Lopez", 2007, (3 * 60) + 32);

            System.out.print("\nFavourites: \n" + favourites);
            System.out.println();

            System.out.println("\nPlay All in Order:");
            favourites.playAll(false);

            System.out.println("\nPlay All Random:");
            favourites.playAll(true);

            System.out.println("\nPlay Only Artist (Multiple) :");
            album.playOnly("Maroon 5");

            System.out.println("\nPlay Only Artist (Single) :");
            album.playOnly("JuStIn"); // testing case-insensitive

            System.out.println("\nPlay Only Artist - Not in Playlist:");
            album.playOnly("Jedward"); // return nothing

            System.out.println("\nPlay Only Year (Multiple) :");
            favourites.playOnly(2002);

            System.out.println("\nPlay Only Year (Single) :");
            favourites.playOnly(2010);

            System.out.println("\nPlay Only Year - Not in Playlist:");
            favourites.playOnly(2000); // return nothing
            System.out.println();

            //Remove song from Playlist
            favourites.remove("Timber"); // Removes Timber
            favourites.remove("Don't stop Believing"); // Nothing removed
            System.out.println("Timber by PitBull removed - Current Playlist: \n" + favourites + "\n");


            //Testing Track Class
            System.out.println("Using methods in Track class - Adding New Track");
            Track track = new Track("Fireflies", "Owl City");

            track = new Track("Fireflies", "Owl City", 2008);

            track = new Track("Fireflies", "Owl City", 2008, (3*60) + 19);

            System.out.println(track);

            if(track.getTitle().equals("Fireflies")){
                track.setTitle("The Fireflies");
            }

            if(track.getArtist().equals("Owl City")){
                track.setArtist("The Owl City");
            }

            if(track.getYear() == 2008){
                track.setYear(2009);
            }

            if(track.getDuration() == (3*60) + 19){
                track.setDuration((3*60) + 20);
            }

            System.out.println(track);

            favourites.add(track);
            favourites.playOnly("Owl");
            System.out.println();

            System.out.println("Favourites playlist with new track added");
            System.out.println(favourites);


        }
}
