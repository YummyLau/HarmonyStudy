package com.effective.harmony.study;

import com.effective.harmony.study.util.LogUtils;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.ability.AbilityLifecycleCallbacks;
import ohos.aafwk.ability.AbilityPackage;
import ohos.app.ElementsCallback;
import ohos.global.configuration.Configuration;
import ohos.utils.PacMap;

public class MyApplication extends AbilityPackage {

    @Override
    public void onInitialize() {
        super.onInitialize();
        registerCallbacks(new AbilityLifecycleCallbacks() {
            @Override
            public void onAbilityStart(Ability ability) {
                LogUtils.debug("%{public}s-onAbilityStart", ability.getClass().getName());
            }

            @Override
            public void onAbilityActive(Ability ability) {
                LogUtils.debug("%{public}s-onAbilityActive", ability.getClass().getName());
            }

            @Override
            public void onAbilityInactive(Ability ability) {
                LogUtils.debug("%{public}s-onAbilityInactive", ability.getClass().getName());
            }

            @Override
            public void onAbilityForeground(Ability ability) {
                LogUtils.debug("%{public}s-onAbilityForeground", ability.getClass().getName());
            }

            @Override
            public void onAbilityBackground(Ability ability) {
                LogUtils.debug("%{public}s-onAbilityBackground", ability.getClass().getName());
            }

            @Override
            public void onAbilityStop(Ability ability) {
                LogUtils.debug("%{public}s-onAbilityStop", ability.getClass().getName());
            }

            @Override
            public void onAbilitySaveState(PacMap pacMap) {
                LogUtils.debug("onAbilitySaveState");
            }
        }, new ElementsCallback() {
            @Override
            public void onMemoryLevel(int i) {
                LogUtils.debug("onMemoryLevel");
            }

            @Override
            public void onConfigurationUpdated(Configuration configuration) {
                LogUtils.debug("onConfigurationUpdated");
            }
        });
        LogUtils.debug("debug","aaa");
        LogUtils.info("info","aaa");
        LogUtils.warn("warn","aaa");
        LogUtils.error("error","aaa");
        LogUtils.fatal("fatal","aaa");
    }
}
