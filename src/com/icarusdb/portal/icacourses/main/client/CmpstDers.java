package com.icarusdb.portal.icacourses.main.client;

import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class CmpstDers extends Composite {

	public CmpstDers(String lbl) {

		VerticalPanel verticalPanel = new VerticalPanel();
		verticalPanel.setStyleName("gwt-Ders");
		initWidget(verticalPanel);

		Label lblNewLabel = new Label(lbl);
		verticalPanel.add(lblNewLabel);

	}

}
