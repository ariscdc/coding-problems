package com.ariscdc.coding.problem.recursion;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static java.util.Arrays.asList;

/**
 * @author ariscdc
 * Aris Dela Cruz
 * https://github.com/ariscdc
 *
 * Find a path to a destination cell in a maze.
 * A maze is made up of four walls, each wall can have a door.
 * The path should not go through the same cell twice.
 *
 * Base Case:
 * The Start Cell is the End Cell.
 *
 * Recursive Case:
 * Keep visiting Cells if a path exists.
 * Do not go to a previously visited Cell.
 *
 * Complexity depends on the number of neighbors for each cell.
 * The higher the connectivity, the higher complexity.
 *
 * 20160220 2020-2040 (20 mins.)
 * 20160220 2220-2225 (5 mins.)
 * 20160221 0000-0010 (10 mins.)
 * 20160221 1035-1115 (40 mins.)
 * 20160221 1420-1425 (5 mins.)
 *                    (85 mins.)
 */
public class FindPathInMaze {

    public static boolean findPath(Cell start, Cell end, Set<Cell> path) {

        path.add(start);
        if (start.equals(end)) {
            showPath(path);
            return true;
        }
        for (Cell neighbor: start.getNeighbors()) {
            if (path.contains(neighbor)) continue;
            if (findPath(neighbor, end, path)) {
                return true;
            } else {
                path.remove(neighbor);
            }
        }
        return false;
    }

    private static void showPath(Set<Cell> path) {

        System.out.print("Path");
        for (Cell cell: path) {
            System.out.print(" -> " + cell.getId());
        }
        System.out.println();
    }

    @SuppressWarnings("all")
    public static void main(String[] args) {

        //     +---+---+---+
        //     | G   H   I |
        // +---+   +   +---+
        // | D | E   F |
        // +   +   +---+
        // | A   B   C |
        // +---+---+---+

        Cell cellA = new Cell("A");
        Cell cellB = new Cell("B");
        Cell cellC = new Cell("C");
        Cell cellD = new Cell("D");
        Cell cellE = new Cell("E");
        Cell cellF = new Cell("F");
        Cell cellG = new Cell("G");
        Cell cellH = new Cell("H");
        Cell cellI = new Cell("I");

        cellA.setNeighbors(asList(cellB, cellD));
        cellB.setNeighbors(asList(cellA, cellC, cellE));
        cellC.setNeighbors(asList(cellB));
        cellD.setNeighbors(asList(cellA));
        cellE.setNeighbors(asList(cellB, cellF, cellG));
        cellF.setNeighbors(asList(cellE, cellH));
        cellG.setNeighbors(asList(cellE, cellH));
        cellH.setNeighbors(asList(cellF, cellG, cellI));
        cellI.setNeighbors(asList(cellH));

        findPath(cellD, cellI, new LinkedHashSet<>());
    }

    private static class Cell {

        private String id;
        private List<Cell> neighbors;

        Cell(String id) {
            this.id = id;
        }

        String getId() {
            return id;
        }

        List<Cell> getNeighbors() {
            return neighbors;
        }

        void setNeighbors(List<Cell> neighbors) {
            this.neighbors = neighbors;
        }

        @Override
        public boolean equals(Object other) {

            if (this == other) return true;
            if (other == null || getClass() != other.getClass()) return false;

            Cell cell = (Cell) other;
            return id.equals(cell.id);
        }

        @Override
        public int hashCode() {
            return id.hashCode();
        }

        @Override
        public String toString() {
            return "Cell{id=" + id + "}";
        }
    }
}
