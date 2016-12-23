package com.neet.DiamondHunter.JavaFX;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class Map {
	
	//size of the tiles in pixel
	private int tileSize;
	private int oriTileSize;
	
	//map
	public int [][] map;
	private int numTilesAcross;
	
	private int numRows;
	private int numCols;
	
	//tiles image store here
	private Image[][] tiles;
	
	
	public Map()
	{
		oriTileSize = 16;
	}

	//load the tiles image into an array
	private void loadTiles()
    {
        Image tilesSet = new Image("/Tilesets/testtileset.gif");
        numTilesAcross = (int) (tilesSet.getWidth() / oriTileSize);
		tiles = new Image[2][numTilesAcross];
		
		for(int col = 0; col < numTilesAcross; col++) {
			tiles[0][col] = new WritableImage(tilesSet.getPixelReader(),
					col * oriTileSize,
					0,
					oriTileSize,
					oriTileSize
					);
			
			tiles[1][col] =new WritableImage(tilesSet.getPixelReader(),
					col * oriTileSize,
					oriTileSize,
					oriTileSize,
					oriTileSize
					);
		}
    }
	
	//load the position for all tiles based on testmap.map
	public void loadMap(int tileSize)
    {
		this.tileSize = tileSize;
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
	
	//draw the map into the scene
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
					row * tileSize,
					tileSize,
					tileSize
				);	
			}	
		}	
	}
}
