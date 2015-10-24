package edu.nju.lms.VO;

import java.util.Calendar;
import java.util.Map;

import edu.nju.lms.PO.Location;

/**
 *@author tj
 *@date 2015年10月24日
 */
public class CheckinVO extends ListVO{
	//every express's location
		private Map<Long,Location> expresses;
		private Calendar checkinDate;
		//every express's destination
		private Map<Long,String> exDestination;
		
		public CheckinVO(long id,Map<Long, Location> expresses, Calendar checkinDate, Map<Long, String> exDestination) {
			super(id);
			this.expresses = expresses;
			this.checkinDate = checkinDate;
			this.exDestination = exDestination;
		}
	    
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Map<Long, Location> getExpresses() {
			return expresses;
		}

		public void setExpresses(Map<Long, Location> expresses) {
			this.expresses = expresses;
		}

		public Calendar getCheckinDate() {
			return checkinDate;
		}

		public void setCheckinDate(Calendar checkinDate) {
			this.checkinDate = checkinDate;
		}

		public Map<Long, String> getExDestination() {
			return exDestination;
		}

		public void setExDestination(Map<Long, String> exDestination) {
			this.exDestination = exDestination;
		}

	

}
