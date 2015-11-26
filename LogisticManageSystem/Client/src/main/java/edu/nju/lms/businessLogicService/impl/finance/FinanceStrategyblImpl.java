package edu.nju.lms.businessLogicService.impl.finance;

import java.rmi.RemoteException;

import edu.nju.lms.PO.PriceStrategyPO;
import edu.nju.lms.PO.SalaryStrategyPO;
import edu.nju.lms.VO.PriceStrategyVO;
import edu.nju.lms.VO.SalaryStrategyVO;
import edu.nju.lms.data.PersonType;
import edu.nju.lms.data.ResultMessage;
import edu.nju.lms.dataService.FinanceStrategyDataService;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class FinanceStrategyblImpl{

	private FinanceStrategyDataService service;
	
	public FinanceStrategyblImpl(FinanceStrategyDataService service){
		this.service=service;
	}
	
	public ResultMessage addPriceStrategy(double std) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		PriceStrategyPO po=new PriceStrategyPO(std);
		try {
			result=service.addPriceStrategy(po);
		} catch (RemoteException e) {
			// TODO
		}
		return result;
	}

	public ResultMessage updatePriceStrategy(double std) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		PriceStrategyPO po=new PriceStrategyPO(std);
		try {
			result=service.updatePriceStrategy(po);
		} catch (RemoteException e) {
			// TODO
		}
		return result;
	}

	public PriceStrategyVO findPriceStrategy() {
		PriceStrategyVO result=null;
		try {
			PriceStrategyPO po=service.findPriceStrategy();
			result=new PriceStrategyVO(po.getStandard(),po.getExpress(),po.getEconomic());
		} catch (RemoteException e) {
			// TODO
		}
		return result;
	}

	public ResultMessage addSalaryStrategy(SalaryStrategyVO salaryStrategy) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		PersonType type=changeToPO(salaryStrategy.getType());
		SalaryStrategyPO po=new SalaryStrategyPO(type,salaryStrategy.getBasic(),
				salaryStrategy.getPerTime(),salaryStrategy.getBonus());
		try {
			result=service.addSalaryStrategy(po);
		} catch (RemoteException e) {
			// TODO
		}
		return result;
	}

	public SalaryStrategyVO findSalaryStrategy(String type) {
		SalaryStrategyVO result=null;
		PersonType POtype=changeToPO(type);
		try {
			SalaryStrategyPO po=service.findSalaryStrategy(POtype);
			String VOtype=changeToVO(po.getType());
			result=new SalaryStrategyVO(VOtype,po.getBasic(),po.getPerTime(),po.getBonus());
		} catch (RemoteException e) {
			// TODO
		}
		return result;
	}

	public ResultMessage updateSalaryStrategy(SalaryStrategyVO salaryStrategy) {
		ResultMessage result=new ResultMessage(false,"网络未连接");
		PersonType type=changeToPO(salaryStrategy.getType());
		SalaryStrategyPO po=new SalaryStrategyPO(type,salaryStrategy.getBasic(),
				salaryStrategy.getPerTime(),salaryStrategy.getBonus());
		try {
			result=service.updateSalaryStrategy(po);
		} catch (RemoteException e) {
			// TODO
		}
		return result;
	}

	public PersonType changeToPO(String duty){
		if(duty.equals("administrator")){
			return PersonType.ADMINISTRATOR;
		}else if(duty.equals("manager")){
			return PersonType.MANAGER;
		}else if(duty.equals("financial_normal")){
			return PersonType.FINANCIAL_NORMAL;
		}else if(duty.equals("financial_advanced")){
			return PersonType.FINANCIAL_ADVANCED;
		}else if(duty.equals("warehouse")){
			return PersonType.WAREHOUSE;
		}else if(duty.equals("counter_intermediate")){
			return PersonType.COUNTER_INTERMEDIATE;
		}else if(duty.equals("counter_bussiness")){
			return PersonType.COUNTER_BUSSINESS;
		}else if(duty.equals("courier")){
			return PersonType.COURIER;
		}else{
			return PersonType.DRIVER;
		}
	}
	public String changeToVO(PersonType duty){
		switch(duty){
		case ADMINISTRATOR:
			return "管理员";
		case MANAGER:
			return "总经理";
		case FINANCIAL_NORMAL:
			return "普通财务人员";
		case FINANCIAL_ADVANCED:
			return "高级财务人员";
		case WAREHOUSE:
			return "中转中心仓库管理人员";
		case COUNTER_INTERMEDIATE:
			return "中转中心业务员";
		case COUNTER_BUSSINESS:
			return "营业厅业务员";
		case COURIER:
			return "快递员";
		case DRIVER:
			return "司机";
		}
		return null;
	}
}
