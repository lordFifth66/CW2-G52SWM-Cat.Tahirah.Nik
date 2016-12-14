package com.neet.DiamondHunter.JavaFX;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class Map {
	
	private int tileSize;
	private int oriTileSize;
	
	private int numTilesAcross;
	private int [][] map;
	
	private int numRows;
	private int numCols;
	
	private Image[][] tiles;
	
	
	public Map(int tileSize)
	{
		this.tileSize = tileSize;
		oriTileSize = 16;
	}

	private void loadTiles()
    {
        Image tilesSet = new Image("/Tilesets/testtileset.gif");
        numTilesAcross = (int) (tilesSet.getWidth() / oriTileSize);
        System.out.println(tilesSet.getWidth());
		tiles = new Image[2][numTilesAcross];
		
		for(int col = 0; col < numTilesAcross; col++) {
			
			tiles[0][col] = new WritableImage(tilesSet.getPixelReader(),
					col * oriTileSize,
					0,
					tileSize,
					tileSize
					);
			
			tiles[1][col] =new WritableImage(tilesSet.getPixelReader(),
					col * oriTileSize,
					oriTileSize,
					tileSize,
					tileSize
					);
		}
    }
	
	public void loadMap()
    {
    	try
    	{
    		InputStream in = getClass().getResourceAsStream("/Maps/testmap.map");
    		BufferedReader br = new BufferedReader(
    				new InputStreamReader(in)
    				);
    		
			numCols = Integer.parseInt(br.readLine());
			numRows = Integer.parseInt(br.readLine());
			map = new int[numRows][numCols];
			
    		String delims = "\\s+";
			for(int row = 0; row < numRows; row++) {
				String line = br.readLine();
				String[] tokens = line.split(delims);
				for(int col = 0; col < numCols; col++) {
					map[row][col] = Integer.parseInt(tokens[col]);
				}
			}
    	}
    	catch(Exception e) {
			e.printStackTrace();
		}
    	loadTiles();
    }
	
public void draw(GraphicsContext gc) {
		
		for(int row = 0; row < numRows; row++) {
		
			if(row >= numRows) break;
			
			for(int col = 0; col < numCols; col++) {
				
				if(col >= numCols) break;
				if(map[row][col] == 0) continue;
				
				int rc = map[row][col];
				int r = rc / numTilesAcross;
				int c = rc % numTilesAcross;
				
				gc.drawImage(
					tiles[r][c],
					col * tileSize,
					row * tileSize
				);
				
			}
			
		}
		
	}
}
