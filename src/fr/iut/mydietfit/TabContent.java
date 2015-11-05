package fr.iut.mydietfit;

import android.content.Context;
import android.view.View;
import android.widget.TabHost.TabContentFactory;

public class TabContent implements TabContentFactory{

	private Context context;
	
	public TabContent(Context context) {
		this.setContext(context);
	}
	
	@Override
	public View createTabContent(String tag) {
		// TODO Auto-generated method stub
		return null;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

}
