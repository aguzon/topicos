package TopicosBowling;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.*;

public class BowlingGameTest {

	private BowlingGame g;

	void rollMany(int n, int pins, BowlingGame g) {
		for (int i = 0; i < n; i++) g.roll(pins);
	}

	@Before
	public void setUp() {
		this.g = new BowlingGame();
	}

	@Test
	public void testZero() {
		rollMany(20, 0, g);
		assertEquals(0, g.score());
	}
	
	@Test
	public void testAllOnes() {
		rollMany(10, 1, g);
		assertEquals(10, g.score());
	}

	@Test
	public void testOneSpare() {
		g.roll(5);
		g.roll(5);
		g.roll(3);
		rollMany(17, 0, g);
		assertEquals(16, g.score());
	
	}
//	Para este caso se tira un pleno y el siguiente suma doble
//	luego compara el resultado esperado con un resultado 
	@Test
	public void testOneStrike() {
		g.roll(10);
		g.roll(3);
//		g.roll(4);
		rollMany(16, 0, g);
		assertEquals(16, g.score());
	}
//	El resultado esperado para el juego perfecto es 300
	@Test
	public void testPerfectGame() {
		rollMany(12, 10, g);
		assertEquals(300, g.score());
	}
	
}