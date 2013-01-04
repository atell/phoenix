package com.dianping.service.editor.page.home;

public enum JspFile {
	VIEW("/jsp/editor/home.jsp"),

	;

	private String m_path;

	private JspFile(String path) {
		m_path = path;
	}

	public String getPath() {
		return m_path;
	}
}
