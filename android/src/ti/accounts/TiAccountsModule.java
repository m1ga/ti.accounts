/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2018 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package ti.accounts;

import android.accounts.Account;
import android.accounts.AccountManager;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;
import org.appcelerator.kroll.common.TiConfig;


@Kroll.module(name="TiAccounts", id="ti.accounts")
public class TiAccountsModule extends KrollModule
{

	// Standard Debugging variables
	private static final String LCAT = "TiAccountsModule";
	private static final boolean DBG = TiConfig.LOGD;

	// You can define constants with @Kroll.constant, for example:
	// @Kroll.constant public static final String EXTERNAL_NAME = value;

	public TiAccountsModule()
	{
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app)
	{
		Log.d(LCAT, "inside onAppCreate");
	}

	// Methods
	@Kroll.method
	public void getAccounts()
	{
		AccountManager am = AccountManager.get(TiApplication.getAppCurrentActivity()); // "this" references the current Context
		Account[] accounts = am.getAccounts();
		Object[] obj = new Object[accounts.length];
		KrollDict kd = new KrollDict();
		int pos = 0;

		for (Account acc : accounts){
			KrollDict kdAccount = new KrollDict();
			kdAccount.put("name", acc.name);
			kdAccount.put("type", acc.type);
			obj[pos] = kdAccount;
			pos++;
		}

		kd.put("accounts", obj);
		fireEvent("accounts", kd);
	}
}

