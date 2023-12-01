/**
 * Album represents an audio production by an artist
 */
public class Album{
	// TODO: add member variables
	private String artistName;
	private String albumName;

	public Album(String nArtist, String nAlbum){
		// TODO: complete constructor
		artistName = nArtist;
		albumName = nAlbum;
	}

	public Album(String albumString){
		// TODO: complete constructor
		String[] albumData = new String[2];
		albumData= albumString.split(" - ");
		artistName = albumData[0];
		albumName = albumData[1];
	}

	@Override
	public String toString(){
		// TODO: print as "artist - album"
		return (artistName + " - " + albumName);
	}

	@Override
	public boolean equals(Object o){
		// TODO: check what o is.  Then check o has same values.
		if (this == o) {
			return true;
		} else if (o instanceof Album) {
			Album a = (Album) o;
			if (this.artistName.equalsIgnoreCase(a.artistName) && this.albumName.equalsIgnoreCase(a.albumName)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public String getArtist() {
		// TODO: return artist name
		return artistName;
	}

	public String getAlbum() {
		// TODO: return album name
		return albumName;
	}
	
}