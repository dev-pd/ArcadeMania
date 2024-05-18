package application;

import java.util.ArrayList;
import java.util.List;

public class Player {

	String name;
	ArrayList<Fighter> party = new ArrayList<>();;
	private Fighter stagedAvenger = null;
	protected  BattleSlot ownedSlot;
    protected BattleSlot enemySlot;
    private boolean canCancelSwap = true;
    
	 protected Player(String _name,List<Fighter> avengers) {
	        name = _name;
	        for (Fighter a: avengers) {
	            party.add(a);
	        }
	    }
	 	
	 public void prepTurn() {
	        canCancelSwap = true;
	        if (ownedSlot.getCurAvenger().isDead()){
	            canCancelSwap = false;
	        }
	    }
	 
	    public Fighter getStagedAvenger(){
	        return stagedAvenger;
	    }

	    public boolean canFight() {
	        for (Fighter a:party) {
	            if(!a.isDead())
	                return true;
	        }
	        return false;
	    }

	    public boolean canSwap(){
	        for (Fighter a:party) {
	            if(!a.isDead() && a != getStagedAvenger())
	                return  true;
	            else{
	                System.out.println(a.name + " is fainted or is already in battle");
	            }
	        }
	        return  false;
	    }
	    
	    public boolean canCancelSwap(){
	        return canCancelSwap;
	    }
	    
	    public void tryToSwap(Fighter avengerToSwapWith){
	        if(canSwap()){
	            if(getStagedAvenger() != avengerToSwapWith){
	                swapAvenger(avengerToSwapWith);
	            }else{
	                System.out.println(avengerToSwapWith.name + " has already been sent out");
	            }
	        }else{
	            System.out.println(name+" can't swap");
	        }
	    }
	    
	    public void swapAvenger(){
	        System.out.println(getStagedAvenger().name + " was recalled");
	        Fighter avengerToSwapWith = sendOutFirstAvailableAvenger();
	        swapAvenger(avengerToSwapWith);
	    }

	    public void swapAvenger(Fighter avengerToSwapWith ){
	        if(avengerToSwapWith == null)
	            System.out.println("swap failed");
	        else{
	            stagedAvenger = avengerToSwapWith;
	            ownedSlot.setAvenger(stagedAvenger);
	        }
	    }

	    public Fighter sendOutFirstAvailableAvenger(){
	        for (Fighter a :party) {
	            if(!a.isDead() && stagedAvenger != a) {
	                return a;
	            }
	        }
	        return  null;
	    }

	    public Fighter stageFirstAvailableAvenger(){
	        Fighter a = sendOutFirstAvailableAvenger();
	        stagedAvenger = a;
	        System.out.println(name+"sending Fighter "+ a.name);
	        return stagedAvenger;
	    }
	    
	    
	    public void prepareForBattle(BattleSlot ownedSlot,BattleSlot enemySlot){
	        this.ownedSlot = ownedSlot;
	        this.enemySlot = enemySlot;
	        
	        ownedSlot.setAvenger(stageFirstAvailableAvenger());
	    }
	    
	    
	
}
