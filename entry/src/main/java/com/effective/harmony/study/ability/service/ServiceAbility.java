package com.effective.harmony.study.ability.service;

import com.effective.harmony.study.util.LogUtils;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;
import ohos.rpc.IRemoteObject;
import ohos.rpc.RemoteObject;

/**
 * Service Ability
 * created by yummylau on 2020/12/24
 */
public class ServiceAbility extends Ability {

    @Override
    public void onStart(Intent intent) {
        LogUtils.debug("CountServiceAbility-onStart");
        super.onStart(intent);
    }

    @Override
    public void onCommand(Intent intent, boolean restart, int startId) {
        LogUtils.debug("CountServiceAbility-onCommand");
        super.onCommand(intent, restart, startId);
    }

    @Override
    public IRemoteObject onConnect(Intent intent) {
        LogUtils.debug("CountServiceAbility-onConnect");
        return new RemoteObject("ServiceAbility");
    }

    @Override
    public void onDisconnect(Intent intent) {
        LogUtils.debug("CountServiceAbility-onDisconnect");
        super.onDisconnect(intent);
    }

    @Override
    public void onStop() {
        LogUtils.debug("CountServiceAbility-onStop");
        super.onStop();
    }

}
