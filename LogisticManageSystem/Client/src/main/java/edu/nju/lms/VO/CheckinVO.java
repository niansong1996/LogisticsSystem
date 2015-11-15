package edu.nju.lms.VO;

import java.util.ArrayList;

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
		
		public CheckinVO(String id,ArrayList<String>expresses, String checkinDate, ArrayList<String> exDestination) {
			super(id);
			this.expresses = expresses;
			this.checkinDate = checkinDate;
			this.exDestination = exDestination;
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

	

}
