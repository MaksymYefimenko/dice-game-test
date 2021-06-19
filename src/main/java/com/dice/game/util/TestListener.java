package com.dice.game.util;

import org.apache.logging.log4j.LogManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.Logger;


public class TestListener implements ITestListener {
    private static final Logger LOG = LogManager.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        LOG.info(String.format("\n** Test %s STARTED **\n", result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LOG.info(String.format("\n** Test %s PASSED **\n", result.getMethod().getMethodName()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LOG.info(String.format("\n** Test %s FAILED **\n", result.getMethod().getMethodName()));
    }

    @Override
    public void onFinish(ITestContext context) {
        LOG.info("\n*** FINISH ***\n");
    }

}
