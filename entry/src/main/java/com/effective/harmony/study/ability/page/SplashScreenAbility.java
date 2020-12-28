package com.effective.harmony.study.ability.page;

import com.effective.harmony.study.ability.page.slice.SplashScreenAbilitySlice;

import com.effective.harmony.study.util.LogUtils;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.agp.window.service.Window;
import ohos.global.icu.text.CaseMap;

/**
 * Splash screen ability
 */
public class SplashScreenAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(SplashScreenAbilitySlice.class.getName());
    }
}