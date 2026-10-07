package com.pm.framework.driver;

import com.microsoft.playwright.Playwright;

public class PlaywrightManager {

    public static Playwright createPlayWright(){
        return Playwright.create();
    }
}
