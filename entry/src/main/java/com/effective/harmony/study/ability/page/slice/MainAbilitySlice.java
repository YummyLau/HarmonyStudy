package com.effective.harmony.study.ability.page.slice;

import com.effective.harmony.study.ResourceTable;

import com.effective.harmony.study.util.IntentUtils;
import com.effective.harmony.study.util.LogUtils;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.ability.IAbilityConnection;
import ohos.aafwk.content.Intent;
import ohos.agp.components.Button;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.bundle.ElementName;
import ohos.rpc.IRemoteObject;

/**
 * Hello world ability slice
 */
public class MainAbilitySlice extends AbilitySlice {

    Text text;
    Button connect;
    Button disconnect;
    private Intent serviceIntent;
    private IAbilityConnection connection;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        initData();
        initView();
        initListener();
    }

    private void initData() {
        serviceIntent = IntentUtils.getCountServiceAbilityIntent(this);
        connection = new IAbilityConnection() {
            @Override
            public void onAbilityConnectDone(ElementName elementName, IRemoteObject iRemoteObject, int i) {
                LogUtils.debug("onAbilityConnectDone");
                text.setText("Service连接状态: 已连接");
            }

            @Override
            public void onAbilityDisconnectDone(ElementName elementName, int i) {
                LogUtils.debug("onAbilityDisconnectDone");
                text.setText("Service连接状态: 断开连接");
            }
        };
    }

    private void initView() {
        text = (Text) findComponentById(ResourceTable.Id_text);
        connect = (Button) findComponentById(ResourceTable.Id_contect);
        disconnect = (Button) findComponentById(ResourceTable.Id_discontect);
    }

    private void initListener() {
        connect.setClickedListener(component -> connectAbility(serviceIntent, connection));
        disconnect.setClickedListener(component -> stopAbility(serviceIntent));
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}