package edu.nju.lms.businessLogicService;

import java.util.ArrayList;

import edu.nju.lms.VO.AccountVO;
import edu.nju.lms.VO.InitialInfoVO;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月25日
 */
public interface FinanceAccountblService {
	// add show delete change 
	public ResultMessage addAccount(AccountVO account);
	
	public AccountVO showAccount(String id);
	
	public ResultMessage deleteAccount(String id);
	
	public ResultMessage updateAccount(AccountVO account);

	public ArrayList<AccountVO> showAllAccount();
	
	public ResultMessage addMoney(String accountName,double amount);
	
	//initial account,including the company's initial financial information
	
	public ResultMessage addInitialInfo(InitialInfoVO initial);
	
	public ArrayList<InitialInfoVO> findInitialInfo();
}
