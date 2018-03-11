/*
 * Copyright 2011 gitblit.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.gitblit.wicket.charting;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.protocol.http.WebApplication;

import javax.servlet.ServletContext;

/**
 * Concrete class for Flotr2 charts
 *
 * @author Tim Ryan
 *
 */
public class Flotr2Charts extends Charts {

	private static final long serialVersionUID = 1L;

	@Override
	public void renderHead(IHeaderResponse response) {

		// add Google Chart JS API reference
		ServletContext servletContext = WebApplication.get().getServletContext();
		String contextPath = servletContext.getContextPath();

        response.render(JavaScriptHeaderItem.forUrl(contextPath + "/bootstrap/js/jquery.js"));
        response.render(JavaScriptHeaderItem.forUrl(contextPath + "/flotr2/flotr2.min.js"));
        response.render(CssHeaderItem.forUrl(contextPath + "/flotr2/flotr2.custom.css"));

		// prepare draw chart function
		StringBuilder sb = new StringBuilder();

		line(sb, "$( document ).ready(function() {");
		line(sb, "try {");
		// add charts to header
		for (Chart chart : charts) {
			chart.appendChart(sb);
		}
		line(sb, "} catch (exception) {");
		line(sb, "  if (window.console && window.console.log) {");
		line(sb, "    window.console.log('flotr2 exception');");
		line(sb, "    window.console.log(exception);");
		line(sb, "  }");
		line(sb, "}");
		// end draw chart function
		line(sb, "});");
		response.renderJavascript(sb.toString(), null);
	}

	@Override
	public Chart createPieChart(String tagId, String title, String keyName,
			String valueName) {
		return new Flotr2PieChart(tagId, title, keyName, valueName);
	}

	@Override
	public Chart createLineChart(String tagId, String title, String keyName,
			String valueName) {
		return new Flotr2LineChart(tagId, title, keyName, valueName);
	}

	@Override
	public Chart createBarChart(String tagId, String title, String keyName,
			String valueName) {
		return new Flotr2BarChart(tagId, title, keyName, valueName);
	}

}
