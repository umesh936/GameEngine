package com.umesh.gameEngine.externalReader;

import java.util.Map;

public interface ExternalReader {
	Map<String, String> getPropertyMapFromEntity(String entityName);
	String getMessageForDisplay(String entity);
}
