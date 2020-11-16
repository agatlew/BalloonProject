import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class BalloonGameTest {
    private lateinit var balloonGame: BalloonGame

    @Mock
    private lateinit var inputOutputHandler: InputOutputHandler

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        balloonGame = BalloonGame(inputOutputHandler)
    }

    @Test
    fun `Show score for correct input`(){
        `when`(inputOutputHandler.userInput).thenReturn("1 2",
                "INFLATE", "BANK", "INFLATE", "INFLATE", "BANK")
        `when`(inputOutputHandler.stringToStringList("1 2")).thenReturn(arrayOf<String>("1","2"))
        `when`(inputOutputHandler.checkIfListOkay(arrayOf<String>("1","2"))).thenReturn(true)
        balloonGame.playGame()
        verify(inputOutputHandler).printOutput("SCORE: 3");
    }

    @Test
    fun `Test game, incorrect input, never display a score or burst`(){
        `when`(inputOutputHandler.userInput).thenReturn("1 x",
                "INFLATE", "BANK", "INFLATE", "INFLATE", "BANK")
        `when`(inputOutputHandler.stringToStringList("1 x")).thenReturn(arrayOf<String>("1","x"))
        `when`(inputOutputHandler.checkIfListOkay(arrayOf<String>("1","x"))).thenReturn(false)
        balloonGame.playGame()
        verify(inputOutputHandler, never()).printOutput("SCORE: 3");
        verify(inputOutputHandler, never()).printOutput("BURST");
    }

    @Test
    fun `Test game, correct input, show one burst, score`(){
        `when`(inputOutputHandler.userInput).thenReturn("1 2",
                "INFLATE", "INFLATE", "INFLATE", "INFLATE", "BANK")
        `when`(inputOutputHandler.stringToStringList("1 2")).thenReturn(arrayOf<String>("1","2"))
        `when`(inputOutputHandler.checkIfListOkay(arrayOf<String>("1","2"))).thenReturn(true)
        balloonGame.playGame()
        verify(inputOutputHandler).printOutput("BURST");
        verify(inputOutputHandler).printOutput("SCORE: 2");
    }

    @Test
    fun `Test game, correct input, show burst twice, score`(){
        `when`(inputOutputHandler.userInput).thenReturn("1 2 1",
                "INFLATE", "INFLATE", "INFLATE", "INFLATE", "BANK", "INFLATE", "INFLATE")
        `when`(inputOutputHandler.stringToStringList("1 2 1")).thenReturn(arrayOf<String>("1","2", "1"))
        `when`(inputOutputHandler.checkIfListOkay(arrayOf<String>("1","2","1"))).thenReturn(true)
        balloonGame.playGame()
        verify(inputOutputHandler, times(2)).printOutput("BURST")
        verify(inputOutputHandler).printOutput("SCORE: 2");
    }
}