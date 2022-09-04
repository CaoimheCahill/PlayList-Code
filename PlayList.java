/**
 * Assignment 2022 Part2 (PlayList Class)
 *
 * Student Number: 21331308
 * Name: Caoimhe Cahill
 *
 * 21st March 2022
 */

import java.util.ArrayList;
import java.util.Random;

public class PlayList {

    String name;
    ArrayList<Track>tracks;

    // Create a PlayList with a default name (e.g. My PlayList)
    public PlayList(){
        this.name = "My PlayList";
        this.tracks = new ArrayList<>();
    }

    // Create a PlayList with the specified name
    public PlayList(String playListName) {
        this.name = playListName;
        this.tracks = new ArrayList<>();
    }

    // Return the contents of PlayList in a readable format
    public String toString(){
        ArrayList<String> contents = new ArrayList<>();
        for (Track track: this.tracks){
            contents.add(track.toString());
        }

        return String.join("\n", contents);
    }

    // Allows name change
    public void setName(String name){
        this.name = name;
    }

    // Returns current name
    public String getName(){
        return this.name;
    }

    // Add a Track where only the title and artist are known
    // The year and duration should be set to zero
    public void add(String title, String artist){

        this.tracks.add(new Track(title, artist));
    }

    // Add a Track where ALL of the data is known
    public void add(String title, String artist, int year, int duration){
        this.tracks.add(new Track(title, artist, year, duration));
    }

    // Add a previously created instance of the Track class
    public void add(Track t){
        this.tracks.add(t);

    }

    // Allow tracks to be deleted from the playlist
    public boolean remove(String title){
        boolean result = false;
            for(int i = this.tracks.size()-1; i>= 0; i--){

            if(this.tracks.get(i).getTitle().equalsIgnoreCase(title)){
                tracks.remove(i);
                result = true;
            }
        }
        return result;
    }

    // Displays the playlist on the screen in sequential order
    public void showList(){
        for(int i = 0; i < this.tracks.size(); i++){
            System.out.println(this.tracks.get(i));
        }

        if(this.tracks.size() == 0){
            System.out.println("This list is empty.");
        }
    }

    // Plays all the tracks in the list either in sequence or randomly
    public void playAll(boolean random){
        ArrayList<Track> tempList = new ArrayList<>(tracks);

        if(!random) {
            for (int i = 0; i < this.tracks.size(); i++) {
                System.out.println(this.tracks.get(i));
            }

            //showList();

        }else {

            for(int i = 0; i < this.tracks.size(); i++) {
                Random random1 = new Random();
                int randomOrder = random1.nextInt(tempList.size());

                System.out.println(tempList.get(randomOrder));

                tempList.remove(randomOrder);
            }
        }

    }

    // Play tracks in the list that satisfy specified criteria
    // Certain artist
    public void playOnly(String artist){
        ArrayList<Track> artistPlaylist = new ArrayList<>();

       for(int i = 0; i < this.tracks.size(); i++) {
            Track track = this.tracks.get(i);

            if(track.getArtist().toLowerCase().contains(artist.toLowerCase())){
                artistPlaylist.add(track);
            }
        }

        for(int i = 0; i < artistPlaylist.size(); i++){
            System.out.println(artistPlaylist.get(i));
        }

    }

    // Certain year
    public void playOnly(int year){
        ArrayList<Track> yearPlaylist = new ArrayList<>();

        for(int i = 0; i < this.tracks.size(); i++) {
            Track track = this.tracks.get(i);
            if(track.getYear() == year){
                yearPlaylist.add(track);
            }
        }

        for(int i = 0; i < yearPlaylist.size(); i++){
            System.out.println(yearPlaylist.get(i));
        }

    }
}
