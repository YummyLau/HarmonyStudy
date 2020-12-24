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
        super.onStart(intent);
        LogUtils.debug("ServiceAbility - ${public}s", "onStart");
    }

    @Override
    public void onCommand(Intent intent, boolean restart, int startId) {
        super.onCommand(intent, restart, startId);
        LogUtils.debug("ServiceAbility - ${public}s", "onCommand");
    }

    @Override
    public IRemoteObject onConnect(Intent intent) {
        super.onConnect(intent);
        LogUtils.debug("ServiceAbility - ${public}s", "onConnect");
        return new RemoteObject("ServiceAbility$RemoteObject");
    }

    @Override
    public void onDisconnect(Intent intent) {
        super.onDisconnect(intent);
        LogUtils.debug("ServiceAbility - ${public}s", "onDisconnect");
    }

    @Override
    public void onStop() {
        super.onStop();
        LogUtils.debug("ServiceAbility - ${public}s", "onStop");
    }

    /**
     * 用于返回外部连接 service 之后获取的对象
     */
    private class RemoteObject extends ohos.rpc.RemoteObject {

        public RemoteObject(String descriptor) {
            super(descriptor);
        }
    }

}
