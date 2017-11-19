package seabattle.game.ship;

import com.fasterxml.jackson.annotation.JsonProperty;
import seabattle.game.field.Cell;

import java.util.ArrayList;

@SuppressWarnings("unused")
public final class Ship {
    private Integer rowPos;
    private Integer colPos;
    private Integer length;
    private Boolean isVertical;

    public Ship(@JsonProperty("rowPos") Integer rowPos, @JsonProperty("colPos") Integer colPos,
                @JsonProperty("length") Integer length, @JsonProperty("isVertical") Boolean isVertical) {
        this.rowPos = rowPos;
        this.colPos = colPos;
        this.length = length;
        this.isVertical = isVertical;
    }

    public Integer getRowPos() {
        return rowPos;
    }

    public void setRowPos(Integer rowPos) {
        this.rowPos = rowPos;
    }

    public Integer getColPos() {
        return colPos;
    }

    public void setColPos(Integer colPos) {
        this.colPos = colPos;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Boolean getIsVertical() {
        return isVertical;
    }

    public void setIsVertical(Boolean isVertical) {
        this.isVertical = isVertical;
    }

    public Boolean inShip(Cell cell) {
        if (isVertical == Boolean.TRUE) {
            return cell.getRowPos() < this.rowPos + this.length;
        }
        return cell.getColPos() < this.colPos + this.length;
    }

    public ArrayList<Cell> getCells() {
        ArrayList<Cell> result = new ArrayList<>();

        if (isVertical) {
            for (Integer i = 0; i < length; ++i) {
                result.add(Cell.of(rowPos + i, colPos));
            }
        } else {
            for (Integer i = 0; i < length; ++i) {
                result.add(Cell.of(rowPos, colPos + i));
            }
        }

        return result;
    }

    public Cell getLastCell() {
        if (isVertical) {
            return Cell.of(rowPos + length - 1, colPos);
        }
        return Cell.of(rowPos, colPos + length - 1);
    }
}
