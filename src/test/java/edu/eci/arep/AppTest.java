package edu.eci.arep;

import junit.framework.Assert;
import junit.framework.Test;

import junit.framework.TestSuite;



import static junit.framework.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
//    public AppTest( String testName )
//    {
//        super( testName );
//    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */

    public void testApp()
    {
        assertTrue( true );
    }


    public void testTitles(){

            String movieJson = HttpServer.htmlWithForms("300");
            String movie = "{\"Title\":\"300\",\"Year\":\"2006\",\"Rated\":\"R\",\"Released\":\"09 Mar 2007\",\"Runtime\":\"117 min\",\"Genre\":\"Action, Drama\",\"Director\":\"Zack Snyder\",\"Writer\":\"Zack Snyder, Kurt Johnstad, Michael B. Gordon\",\"Actors\":\"Gerard Butler, Lena Headey, David Wenham\",\"Plot\":\"King Leonidas of Sparta and a force of 300 men fight the Persians at Thermopylae in 480 B.C.\",\"Language\":\"English\",\"Country\":\"United States, Canada, Bulgaria\",\"Awards\":\"19 wins & 57 nominations\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMjc4OTc0ODgwNV5BMl5BanBnXkFtZTcwNjM1ODE0MQ@@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"7.6/10\"},{\"Source\":\"Rotten Tomatoes\",\"Value\":\"61%\"},{\"Source\":\"Metacritic\",\"Value\":\"52/100\"}],\"Metascore\":\"52\",\"imdbRating\":\"7.6\",\"imdbVotes\":\"826,361\",\"imdbID\":\"tt0416449\",\"Type\":\"movie\",\"DVD\":\"31 Jul 2007\",\"BoxOffice\":\"$210,629,101\",\"Production\":\"N/A\",\"Website\":\"N/A\",\"Response\":\"True\"}";
            Assert.assertEquals(movie, movieJson);

    }




}



