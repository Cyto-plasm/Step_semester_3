class Playlist {
    private String[] songs;
    private int songCount;

    Playlist(int maxSongs) {
        songs = new String[maxSongs];
        songCount = 0;
    }

    public void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    public String[] getSongs() {
        String[] copy = new String[songCount];

        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    public int getSongCount() {
        return songCount;
    }
}

public class PlaylistDemo {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        System.out.println("First song: " + copy[0]);
        System.out.println("Second song: " + copy[1]);

        copy[0] = "Hacked";

        String[] check = p.getSongs();

        System.out.println("First song after modification: " + check[0]);
        System.out.println("Song count: " + p.getSongCount());
    }
}
