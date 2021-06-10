package edu.westga.cs6910.pig.model;

/**
 * ComputerPlayer represents a very simple automated player in the game Pig. It
 * rolls exactly 1 time and then holds.
 * 
 * @author Alex Kernan
 * @version 6/8/2021
 */
public class ComputerPlayer extends AbstractPlayer  implements Player {
	private static final String NAME = "Simple computer";
	private int maximumRolls;

	/**
	 * Creates a new ComputerPlayer with the specified name.
	 */

	public ComputerPlayer() {
		super(NAME);
	}

	/**
	 * Implements Player's setMaximumRolls, but is not normally called by client
	 * objects. Instead, clients usually call the 0-parameter version
	 * 
	 * @param maximumRolls The maximum number of times the computer will roll before
	 *                     holding
	 */
	public void setMaximumRolls(int maximumRolls) {
		this.maximumRolls = maximumRolls;
	}

	/**
	 * Implements Player's setMaximumRolls() to set the maximum number of rolls to 1
	 * 
	 */
	public void setMaximumRolls() {
		this.maximumRolls = 1;
	}

	@Override
	/**
	 * @see Player#takeTurn()
	 */
	public void takeTurn() {
		for (int count = 0; count < this.maximumRolls; count++) {
			super.getDicePair().rollDice();

			int die1Value = super.getDicePair().getDie1Value();
			int die2Value = super.getDicePair().getDie2Value();
			int total =  super.getTotal();
			int turnTotal = super.getTurnTotal();
			
			if (die1Value == 1 || die2Value == 1) {	
				total -= turnTotal;
			} else {
				turnTotal += die1Value + die2Value;
				total += die1Value + die2Value;
				
				super.setTotal(total);
				super.setTurnTotal(turnTotal);
				
			}
		}
		super.setIsMyTurn(false);
	}

}
