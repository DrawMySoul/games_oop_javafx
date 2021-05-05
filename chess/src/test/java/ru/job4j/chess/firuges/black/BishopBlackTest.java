package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.FigureNotFoundException;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

	@Test
	public void position() {
		BishopBlack bishopBlack = new BishopBlack(Cell.A1);
		Cell expected = Cell.A1;
		assertThat(bishopBlack.position(), is(expected));
	}

	@Test
	public void copy() {
		BishopBlack bishopBlack = new BishopBlack(Cell.A1);
		Figure figure = bishopBlack.copy(Cell.B3);
		Cell expected = Cell.B3;
		assertThat(figure.position(), is(expected));
	}

	@Test
	public void way() {
		BishopBlack bishopBlack = new BishopBlack(Cell.C1);
		Cell[] result = bishopBlack.way(Cell.G5);
		Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
		assertThat(result, is(expected));
	}

	@Test(expected = ImpossibleMoveException.class)
	public void diagonalFalse() {
		BishopBlack bishopBlack = new BishopBlack(Cell.C1);
		bishopBlack.way(Cell.G6);
	}
}