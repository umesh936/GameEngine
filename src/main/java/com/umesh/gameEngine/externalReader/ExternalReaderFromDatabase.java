package com.umesh.gameEngine.externalReader;

import java.util.Map;

/**
 * If user want to place all configuration can place in database they have to give implementation of this class
 * and can use database tables for this. Here Game Name will be different database. 
 * @author umesh
 *
 */
public class ExternalReaderFromDatabase implements ExternalReader{

	@Override
	public Map<String, String> getPropertyMapFromEntity(String entityName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getMessageForDisplay(String entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
