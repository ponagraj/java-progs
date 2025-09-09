package com.programs.dp;

/**
 * https://www.geeksforgeeks.org/minimize-cost-of-painting-n-houses-such-that-adjacent-houses-have-different-colors/
 * @author VineelaNagu
 *
 */
public class PaintHouse {
	
	public static int minPaintCost;
	public static void main(String[] args) {
		int N = 3;
		int cost[][] = {{14, 2, 11}, {11, 14, 5}, {14, 3, 10}};
		System.out.println("Rec: " +minPaintRec(cost));
	}
	
	public static int minPaintRec(int cost[][]) {
		minPaintCost = Integer.MAX_VALUE;
		minPaints(cost, 0, 0, -1);
		return minPaintCost;
	}

	private static void minPaints(int[][] cost, int houseNo, int paintCost, int prevPaint) {
		if(houseNo >= cost.length) {
			if(minPaintCost >= paintCost) {
				minPaintCost = paintCost;
			}
			return;
		}
		//for(int i=houseNo; i<cost.length; i++) {//houses
			for(int j=0; j<cost[houseNo].length; j++) {//paint cost
					minPaints(cost, houseNo+1, paintCost+cost[houseNo][j],j);
			}
		//}
	}
	
	
}
