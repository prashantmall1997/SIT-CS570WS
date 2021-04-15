package Maze;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Class that solves maze problems with backtracking.
 * 
 * @author Koffman and Wolfgang
 **/
public class Maze implements GridColors {

	/** The maze */
	private TwoDimGrid maze;

	public Maze(TwoDimGrid m) {
		maze = m;
	}

	/** Wrapper method. */
	public boolean findMazePath() {
		return findMazePath(0, 0); // (0, 0) is the start point.
	}

	/**
	 * Attempts to find a path through point (x, y).
	 * 
	 * @pre Possible path cells are in BACKGROUND color; barrier cells are in
	 *      ABNORMAL color.
	 * @post If a path is found, all cells on it are set to the PATH color; all
	 *       cells that were visited but are not on the path are in the TEMPORARY
	 *       color.
	 * @param x The x-coordinate of current point
	 * @param y The y-coordinate of current point
	 * @return If a path through (x, y) is found, true; otherwise, false
	 */

	// COMPLETE HERE FOR PROBLEM 1
	public boolean findMazePath(int x, int y) {
		// Check if x and y values fall in grid
		if (x < 0 || x >= maze.getNCols() || y < 0 || y >= maze.getNRows()) {
			return false;
		} else if (maze.getColor(x, y) != NON_BACKGROUND) { // Check if block color is NON_BACKGROUND (RED)
			return false;
		} else if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) { // Check if exit block
			maze.recolor(x, y, PATH);
			return true;
		} else { // Assumed to be part of the path
			maze.recolor(x, y, PATH);
			if (findMazePath(x + 1, y) || findMazePath(x, y - 1) || findMazePath(x - 1, y) || findMazePath(x, y + 1)) {
				return true;
			} else {
				maze.recolor(x, y, TEMPORARY); // Dead End
				return false;
			}
		}
	}

	// ADD METHOD FOR PROBLEM 2 HERE
	public ArrayList<ArrayList<PairInt>> findAllMazePaths(int x, int y) {
		boolean pathFound = findMazePath(); // Check if any possible path exists
		if (pathFound) {
			maze.recolor(PATH, NON_BACKGROUND); // Reset color to NON_BACGROUND as it got modified by findMazePath()
			maze.recolor(TEMPORARY, NON_BACKGROUND);
			ArrayList<ArrayList<PairInt>> result = new ArrayList<>();
			Stack<PairInt> trace = new Stack<>();
			findMazePathStackBased(0, 0, result, trace);
			return result;
		} else {
			maze.recolor(PATH, NON_BACKGROUND); // Reset color to NON_BACGROUND as it got modified by findMazePath()
			maze.recolor(TEMPORARY, NON_BACKGROUND);
			ArrayList<ArrayList<PairInt>> result = new ArrayList<ArrayList<PairInt>>(); // Create empty list to return
			ArrayList<PairInt> empty = new ArrayList<PairInt>();
			result.add(empty);
			return result;
		}
	}

	// Helper Method
	public void findMazePathStackBased(int x, int y, ArrayList<ArrayList<PairInt>> result, Stack<PairInt> trace) {
		if (x < 0 || x >= maze.getNCols() || y < 0 || y >= maze.getNRows()) { // Check if array block coordinates out of
																				// bound
			return;
		} else if (maze.getColor(x, y) != NON_BACKGROUND) { // Check if array block allowed to traverse
			return;
		} else if (x == maze.getNCols() - 1 && y == maze.getNRows() - 1) { // Check if exit block
			maze.recolor(x, y, NON_BACKGROUND);
			trace.push(new PairInt(x, y));
			ArrayList<PairInt> current = new ArrayList<>();
			current.addAll(trace);
			result.add(current);// Add path to arraylist result
			trace.pop();
			return;
		} else {
			maze.recolor(x, y, PATH);
			trace.push(new PairInt(x, y));
			findMazePathStackBased(x + 1, y, result, trace);
			findMazePathStackBased(x, y + 1, result, trace);
			findMazePathStackBased(x, y - 1, result, trace);
			findMazePathStackBased(x - 1, y, result, trace);
			trace.pop();
			maze.recolor(x, y, NON_BACKGROUND);
			return;
		}
	}

	// ADD METHOD FOR PROBLEM 3 HERE
	public ArrayList<PairInt> findMazePathMin(int x, int y) {
		maze.recolor(PATH, NON_BACKGROUND); // Reset color to NON_BACGROUND as it got modified by findMazePath()
		maze.recolor(TEMPORARY, NON_BACKGROUND);

		ArrayList<ArrayList<PairInt>> paths = findAllMazePaths(x, y);

		if (paths.size() != 0) {
			ArrayList<PairInt> shortestPath = paths.get(0);

			int shortestPathSize = shortestPath.size();
			for (int counter = 1; counter < paths.size(); counter++) {
				if (shortestPathSize >= paths.get(counter).size()) {
					shortestPath = paths.get(counter);
					shortestPathSize = shortestPath.size();
				}
			}
			return shortestPath;
		} else {
			return new ArrayList<PairInt>();
		}
	}

	/* <exercise chapter="5" section="6" type="programming" number="2"> */
	public void resetTemp() {
		maze.recolor(TEMPORARY, BACKGROUND);
	}
	/* </exercise> */

	/* <exercise chapter="5" section="6" type="programming" number="3"> */
	public void restore() {
		resetTemp();
		maze.recolor(PATH, BACKGROUND);
		maze.recolor(NON_BACKGROUND, BACKGROUND);
	}
	/* </exercise> */
}
/* </listing> */
