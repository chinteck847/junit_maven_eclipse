/**
 * 
 */
package com.sddevops.junit_maven.eclipse;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */
class SongCollectionTest {
	
	private SongCollection sc;
	private SongCollection sc2;
	private Song s1;
	private Song s2;
	private Song s3;
	private Song s4;
	private final int SONG_COLLECTION_SIZE=4;
	private int capacity = 2 ;
	ArrayList<Song> songs = new ArrayList<>();
	

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		//Arrange
		sc=new SongCollection();
		s1 = new Song("001","good 4 u","Olivia Rodrigo",3.59);
		s2 = new Song("002","Peaches","Justin Bieber",3.18);
		s3 = new Song("003","MONTERO","Lil Nas",2.3);
		s4 = new Song("004","bad guy","billie eilish",3.14);
		sc.addSong(s1);
		sc.addSong(s2);
		sc.addSong(s3);
		sc.addSong(s4);
	    songs.add(s1);
	    songs.add(s2);
	    songs.add(s3);
	    songs.add(s4);
		
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.SongCollection#getSongs()}.
	 */
	@Test
	void testGetSongs() {
		
		List<Song> testSc=sc.getSongs();
		//Assert that Song Collection is equals to Song Collection Size : 4
		assertEquals(testSc.size(),SONG_COLLECTION_SIZE);
		//Act
		sc.addSong(s1);
		//Assert that Song Collection is equals to Song Collection Size + 1 : 5
		assertEquals(testSc.size(),SONG_COLLECTION_SIZE+1);
		
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.SongCollection#addSong(com.sddevops.junit_maven.eclipse.Song)}.
	 */
	@Test
	void testAddSong() {
		
		//Arrange
		sc2=new SongCollection(2);
		sc2.addSong(s1);
		sc2.addSong(s2);
		sc2.addSong(s3);
		List<Song> testSc=sc2.getSongs();
		//Assert that Song Collection is 2 if adding over capacity
		assertEquals(testSc.size(),2);
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.SongCollection#sortSongsByTitle()}.
	 */
	@Test
	void testSortSongsByTitle() {
		ArrayList<Song> sortedSongs = sc.sortSongsByTitle();
		assertEquals("MONTERO",sortedSongs.get(0).getTitle());
		assertEquals("Peaches",sortedSongs.get(1).getTitle());
		assertEquals("bad guy",sortedSongs.get(2).getTitle());
		assertEquals("good 4 u",sortedSongs.get(3).getTitle());
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.SongCollection#sortSongsBySongLength()}.
	 */
	@Test
	void testSortSongsBySongLength() {
		sc.sortSongsBySongLength();
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.SongCollection#findSongsById(java.lang.String)}.
	 */
	@Test
	void testFindSongsById() {
		assertEquals(sc.findSongsById("001"),s1);
		assertEquals(sc.findSongsById("010"),null);
	}

	/**
	 * Test method for {@link com.sddevops.junit_maven.eclipse.SongCollection#findSongByTitle(java.lang.String)}.
	 */
	@Test
	void testFindSongByTitle() {
		assertEquals(sc.findSongByTitle("good 4 u"),s1);
		assertEquals(sc.findSongByTitle("dumdummusic"),null);
	}

}
