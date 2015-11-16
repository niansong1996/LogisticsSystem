package edu.nju.lms.businessLogicService.impl.finance;

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

	public AccountVO showAccount(String id) {
		// TODO Auto-generated method stub
	    return new AccountVO("1256975631269789",100000);
	}

	public ResultMessage deleteAccount(String id) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

	public ResultMessage addInitialInfo(InitialInfoVO initial) {
		// TODO Auto-generated method stub
		return new ResultMessage(true,null);
	}

}
