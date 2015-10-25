package edu.nju.lms.VO;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class CheckinVO extends ListVO{
	    /**
	     * id+location
	     */
		private String[] expresses;
		private String checkinDate;
		/**
		 * id+destination
		 */
		private String[] exDestination;
		public CheckinVO(String id,String[] expresses, String checkinDate, String[] exDestination) {
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

		public String[] getExpresses() {
			return expresses;
		}

		public void setExpresses(String[] expresses) {
			this.expresses = expresses;
		}

		public String getCheckinDate() {
			return checkinDate;
		}

		public void setCheckinDate(String checkinDate) {
			this.checkinDate = checkinDate;
		}

		public String[] getExDestination() {
			return exDestination;
		}

		public void setExDestination(String[] exDestination) {
			this.exDestination = exDestination;
		}

	

}
