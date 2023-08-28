package app;
import java.awt.*;
import javax.swing.*;
import java.sql.*;

public class FindWinner {
	private int z=-1;
	public FindWinner(JButton[] grid, JLabel scorel, int times, JButton again) {
		if(grid[0].getText().equals(grid[1].getText()) && grid[1].getText().equals(grid[2].getText()) && times>4) {
        	z=0;	
        }else if(grid[3].getText().equals(grid[4].getText()) && grid[4].getText().equals(grid[5].getText()) && times>4) {
        	z=3;
        }else if(grid[6].getText().equals(grid[7].getText()) && grid[7].getText().equals(grid[8].getText()) && times>4) {
        	z=6;
        }else if(grid[0].getText().equals(grid[3].getText()) && grid[3].getText().equals(grid[6].getText()) && times>4) {
        	z=0;
        }else if(grid[1].getText().equals(grid[4].getText()) && grid[4].getText().equals(grid[7].getText()) && times>4) {
        	z=1;
        }else if(grid[2].getText().equals(grid[5].getText()) && grid[5].getText().equals(grid[8].getText()) && times>4) {
        	z=2;
        }else if(grid[0].getText().equals(grid[4].getText()) && grid[4].getText().equals(grid[8].getText()) && times>4) {
        	z=0;
        }else if(grid[6].getText().equals(grid[4].getText()) && grid[4].getText().equals(grid[2].getText()) && times>4) {
        	z=6;
        }else if(times == 9){
        	scorel.setText("It is a tie");
        	
        }
		
		if(z!= -1) {
			if(grid[z].getText() == "X") {
				scorel.setText("Player Won!");
				for(int i=0;i<9;i++) {
					if(grid[i].getText().equals("X")){
						grid[i].setBackground(Color.red);
					}
				}
				
			}else {
				scorel.setText("Computer Won!");
				for(int i=0;i<9;i++) {
					if(grid[i].getText().equals("O")){
						grid[i].setBackground(Color.red);
					}
				}
			}
			for(int i=0;i<9;i++) {
				if(grid[i].isEnabled()) {
					grid[i].setText("");
					grid[i].setEnabled(false);
					
				}
			}
			again.setEnabled(true);
		}else {
			scorel.setText(scorel.getText());
		}
		
	}

}
