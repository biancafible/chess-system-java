package bordgame;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;

	public Board(int rows, int columns) {
		
		if(rows < 1 || columns < 1) {
			throw new BoardException("FALTO LINHA OU COLUNA HEIN");
		}
		
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public Piece piece(int row, int column) {
		if(!positionExists(row, column)){
			throw new BoardException("Posição n ta no tabuleiro");
		}
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		if(!positionExists(position)){
			throw new BoardException("Posição n ta no tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position)) {
			throw new BoardException("Já existe uma peça nesta posição");
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	public Boolean positionExists(int row, int column) {
		return row >= 0 
			&& row < rows 
			&& column >=0 
			&& column < columns;
	}

	public Boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public Boolean thereIsAPiece(Position position) {
		if(!positionExists(position)){
			throw new BoardException("Posição n ta no tabuleiro");
		}
		return piece(position) != null;
	}
}
