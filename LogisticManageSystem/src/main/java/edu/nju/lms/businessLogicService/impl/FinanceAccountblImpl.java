package edu.nju.lms.businessLogicService.impl;

import edu.nju.lms.VO.AccountVO;
import edu.nju.lms.VO.InitialInfoVO;
import edu.nju.lms.businessLogicService.FinanceAccountblService;
import edu.nju.lms.data.ResultMessage;

/**
 *@author tj
 *@date 2015年10月25日
 */
public class FinanceAccountblImpl implements FinanceAccountblService {

	public ResultMessage addAccount(AccountVO account) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public AccountVO showAccount(long id) {
		// TODO Auto-generated method stub
	    return null;
	}

	public ResultMessage deleteAccount(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage updateAccount(AccountVO account) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage addInitialInfo(InitialInfoVO initial) {
		// TODO Auto-generated method stub
		return null;
	}

}
