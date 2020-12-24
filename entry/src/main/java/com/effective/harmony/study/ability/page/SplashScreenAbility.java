package com.effective.harmony.study.ability.page;

import com.effective.harmony.study.ability.page.slice.SplashScreenAbilitySlice;

import com.effective.harmony.study.util.LogUtils;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

/**
 * Splash screen ability
 */
public class SplashScreenAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(SplashScreenAbilitySlice.class.getName());
        LogUtils.debug("%{public}s loves harmonyOS","yummylau");
        LogUtils.info("%{public}s loves harmonyOS","yummylau");
        LogUtils.warn("%{public}s loves harmonyOS","yummylau");
        LogUtils.error("%{public}s loves harmonyOS","yummylau");
        LogUtils.fatal("%{public}s loves harmonyOS","yummylau");
    }
}