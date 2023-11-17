package com.anhtester.Bai26_ParallelExecutionPOM.testcases;

import com.anhtester.Bai26_ParallelExecutionPOM.pages.CustomerPage;
import com.anhtester.Bai26_ParallelExecutionPOM.pages.DashboardPage;
import com.anhtester.Bai26_ParallelExecutionPOM.pages.LoginPage;
import com.anhtester.Bai26_ParallelExecutionPOM.pages.ProfilePage;
import com.anhtester.common.BaseTest;
import com.anhtester.constants.ConfigData;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomerPage customerPage;
    ProfilePage profilePage;

    private String CUSTOMER_NAME = "Viettel A6";

    @Test
    public void testAddNewCustomer() {
        loginPage = new LoginPage();
        dashboardPage = loginPage.loginCRM(ConfigData.EMAIL, ConfigData.PASSWORD);
        loginPage.verifyLoginSuccess();

        customerPage = dashboardPage.clickMenuCustomers();

        customerPage.verifyRedirectCustomerPageSuccess();
        customerPage.clickButtonAddNew();
        customerPage.inputDataCustomer(CUSTOMER_NAME);
        dashboardPage.clickMenuCustomers();

        profilePage = customerPage.searchCustomer(CUSTOMER_NAME);
        profilePage.verifyCustomerDetail(CUSTOMER_NAME);

    }
}
