package edu.nju.lms.VO;

import java.util.ArrayList;

import edu.nju.lms.PO.Location;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class CheckinVO extends ListVO{
	    /**
	     * id+location
	     */
		private ArrayList<String> expresses;
		private String checkinDate;
		/**
		 * id+destination
		 */
		private ArrayList<String> exDestination;
		private ArrayList<Location> location;
		public CheckinVO(String id,ArrayList<Location> location,ArrayList<String>expresses,ArrayList<String> exDestination){
			super(id);
			this.expresses = expresses;
			this.location = location;
			this.exDestination = exDestination;
		}
		public CheckinVO(String id,ArrayList<Location> location,ArrayList<String>expresses, String checkinDate, ArrayList<String> exDestination) {
			super(id);
			this.expresses = expresses;
			this.checkinDate = checkinDate;
			this.exDestination = exDestination;
			this.location = location;
		}
	    
		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public ArrayList<String> getExpresses() {
			return expresses;
		}

		public void setExpresses(ArrayList<String> expresses) {
			this.expresses = expresses;
		}

		public String getCheckinDate() {
			return checkinDate;
		}

		public void setCheckinDate(String checkinDate) {
			this.checkinDate = checkinDate;
		}

		public ArrayList<String> getExDestination() {
			return exDestination;
		}

		public void setExDestination(ArrayList<String> exDestination) {
			this.exDestination = exDestination;
		}

		public ArrayList<Location> getLocation() {
			return location;
		}

		public void setLocation(ArrayList<Location> location) {
			this.location = location;
		}

	

}
