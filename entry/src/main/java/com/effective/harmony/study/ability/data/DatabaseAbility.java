package com.effective.harmony.study.ability.data;

import ohos.aafwk.ability.Ability;
import ohos.aafwk.ability.DataAbilityOperation;
import ohos.aafwk.ability.DataAbilityResult;
import ohos.aafwk.ability.OperationExecuteException;
import ohos.aafwk.content.Intent;
import ohos.data.DatabaseHelper;
import ohos.data.dataability.DataAbilityPredicates;
import ohos.data.orm.OrmContext;
import ohos.data.rdb.ValuesBucket;
import ohos.data.resultset.ResultSet;
import ohos.utils.net.Uri;

import java.util.ArrayList;

/**
 * Data Ability，用于提供外部程序访问数据入口,数据库数据
 * created by yummylau on 2020/12/24
 */
public class DatabaseAbility extends Ability {

    private static final String DATABASE_NAME ="UserDataAbility.db";
    private static final String DATABASE_NAME_ALIAS = "UserDataAbility";
    private OrmContext ormContext = null;

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        DatabaseHelper manager = new DatabaseHelper(this);
//        ormContext = manager.getOrmContext(DATABASE_NAME_ALIAS, DATABASE_NAME, BookStore.class);
    }


    @Override
    public ResultSet query(Uri uri, String[] columns, DataAbilityPredicates predicates) {
        return super.query(uri, columns, predicates);
    }

    @Override
    public int insert(Uri uri, ValuesBucket value) {
        return super.insert(uri, value);
    }

    @Override
    public int update(Uri uri, ValuesBucket value, DataAbilityPredicates predicates) {
        return super.update(uri, value, predicates);
    }

    @Override
    public int delete(Uri uri, DataAbilityPredicates predicates) {
        return super.delete(uri, predicates);
    }


    @Override
    public DataAbilityResult[] executeBatch(ArrayList<DataAbilityOperation> operations) throws OperationExecuteException {
        return super.executeBatch(operations);
    }
}