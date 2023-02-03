package edu.eci.arep;

import org.testng.annotations.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class HttpTest {

    @Test
    public void testApp() throws IOException {
        String real = HttpConection.HttpConectionExample("t=Indiana");
        String expectedJson ="{\"Title\":\"Indiana Jones and the Raiders of the Lost Ark\",\"Year\":\"1981\",\"Rated\":\"PG\",\"Released\":\"12 Jun 1981\",\"Runtime\":\"115 min\",\"Genre\":\"Action, Adventure\",\"Director\":\"Steven Spielberg\",\"Writer\":\"Lawrence Kasdan, George Lucas, Philip Kaufman\",\"Actors\":\"Harrison Ford, Karen Allen, Paul Freeman\",\"Plot\":\"Archaeology professor Indiana Jones ventures to seize a biblical artefact known as the Ark of the Covenant. While doing so, he puts up a fight against Renee and a troop of Nazis.\",\"Language\":\"English, German, Hebrew, Spanish, Arabic, Nepali\",\"Country\":\"United States\",\"Awards\":\"Won 4 Oscars. 38 wins & 24 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNTU2ODkyY2MtMjU1NC00NjE1LWEzYjgtMWQ3MzRhMTE0NDc0XkEyXkFqcGdeQXVyMjM4MzQ4OTQ@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.4/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"96%\"},{\"Source\":\"Metacritic\",\"Value\":\"85/100\"}],\"Metascore\":\"85\",\"imdbRating\":\"8.4\",\"imdbVotes\":\"972,272\",\"imdbID\":\"tt0082971\",\"Type\":\"movie\",\"DVD\":\"13 May 2008\",\"BoxOffice\":\"$248,159,971\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}";
        assertEquals(expectedJson, real);
    }

    @Test
    public void testApp2() throws IOException {
        String real = HttpConection.HttpConectionExample("t=up");
        String expectedJson = "{\"Title\":\"Up\",\"Year\":\"2009\",\"Rated\":\"PG\",\"Released\":\"29 May 2009\",\"Runtime\":\"96 min\",\"Genre\":\"Animation, Adventure, Comedy\",\"Director\":\"Pete Docter, Bob Peterson\",\"Writer\":\"Pete Docter, Bob Peterson, Tom McCarthy\",\"Actors\":\"Edward Asner, Jordan Nagai, John Ratzenberger\",\"Plot\":\"78-year-old Carl Fredricksen travels to Paradise Falls in his house equipped with balloons, inadvertently taking a young stowaway.\",\"Language\":\"English\",\"Country\":\"United States\",\"Awards\":\"Won 2 Oscars. 80 wins & 87 nominations total\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMTk3NDE2NzI4NF5BMl5BanBnXkFtZTgwNzE1MzEyMTE@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.3/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"98%\"},{\"Source\":\"Metacritic\",\"Value\":\"88/100\"}],\"Metascore\":\"88\",\"imdbRating\":\"8.3\",\"imdbVotes\":\"1,048,998\",\"imdbID\":\"tt1049413\",\"Type\":\"movie\",\"DVD\":\"10 Nov 2009\",\"BoxOffice\":\"$293,004,164\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}";
        assertEquals(expectedJson, real);
    }

}
