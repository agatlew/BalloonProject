import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
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

//    @Test
//    fun `peierwszy test`(){
//        val plainInput = "2 4 1"
//        val immutableListOfStrings = arrayOf<String>("2","4","1")
//        `when`(inputOutputHandler.userInput).thenReturn("4 5 3")
//        `when`(inputOutputHandler.stringToStringList("2 3 4")).thenReturn(arrayOf<String>("2","3","4"))
//        `when`(inputOutputHandler.checkIfListOkay(arrayOf<String>("2","3","4"))).thenReturn(true)
//        balloonGame.playGame()
//        verify(inputOutputHandler).printOutput("");
//    }

    @Test
    fun `drugi test`(){
        `when`(inputOutputHandler.userInput).thenReturn("1 2", "INFLATE", "BANK", "INFLATE", "INFLATE", "BANK")
        `when`(inputOutputHandler.stringToStringList("1 2")).thenReturn(arrayOf<String>("1","2"))
        `when`(inputOutputHandler.checkIfListOkay(arrayOf<String>("1","2"))).thenReturn(true)

        balloonGame.playGame()
        verify(inputOutputHandler).printOutput("SCORE: 3");
    }


}