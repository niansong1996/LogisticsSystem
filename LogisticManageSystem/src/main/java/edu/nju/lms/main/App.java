package edu.nju.lms.main;

import edu.nju.lms.businessLogicService.UserblService;
import edu.nju.lms.businessLogicService.impl.UserblImpl;
import edu.nju.lms.dataService.UserDataService;
import edu.nju.lms.dataService.impl.UserDataImpl;
import edu.nju.lms.presentation.MainFrame;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        UserDataService userData = new UserDataImpl();
        UserblService userbl = new UserblImpl(userData);
        MainFrame frame = new MainFrame(userbl);
    }
}
